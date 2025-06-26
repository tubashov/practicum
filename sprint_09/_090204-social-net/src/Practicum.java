import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

class PostsHandler implements HttpHandler {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private final List<Post> posts;

    private final Map<Integer, List<Comment>> commentsByPostId = new HashMap<>();

    public PostsHandler(List<Post> posts) {
        this.posts = posts;
        for (Post post : posts) {
            commentsByPostId.put(post.getId(), post.getComments());
        }
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Endpoint endpoint = getEndpoint(exchange.getRequestURI().getPath(), exchange.getRequestMethod());

        switch (endpoint) {
            case GET_POSTS: {
                handleGetPosts(exchange);
                break;
            }
            case GET_COMMENTS: {
                handleGetComments(exchange);
                break;
            }
            case POST_COMMENT: {
                handlePostComments(exchange);
                break;
            }
            default:
                writeResponse(exchange, "Такого эндпоинта не существует", 404);
        }
    }

    private void handleGetPosts(HttpExchange exchange) throws IOException {
        // верните ответ, представляющий список постов. Код ответа должен быть 200.
        // информация по каждому посту должна начинаться с новой строки.
        // для преобразования объекта поста в строку воспользуйтесь его методом toString

        // создать список, в котором будут храниться посты
        List<Post> postList = this.posts;

        // собрать строку-ответ. Каждый пост с новой строки
        StringBuilder responseBuilder = new StringBuilder();
        // каждый пост добавляется в список
        for (Post post : posts){
            responseBuilder.append(post.toString()).append("\n");
        }
        String response = responseBuilder.toString().trim(); // trim() - удаление последней пустой строки

        // установить HTTP-заголовки
        byte[] responseBytes = response.getBytes(DEFAULT_CHARSET);
        exchange.sendResponseHeaders(200, responseBytes.length);

        // отправить тело ответа через поток try-with-recourses автоматически закроет поток после записи
        try(OutputStream os = exchange.getResponseBody()) {
            os.write(responseBytes);
        }

    }

    private void handleGetComments(HttpExchange exchange) throws IOException {
        Optional<Integer> postIdOpt = getPostId(exchange);

        /* Верните комментарии указанного поста. Информация о каждом комментарии
           должна начинаться с новой строки. Код статуса — 200.
           Если запрос был составлен неверно, верните сообщение об ошибке с кодом 400.
           Если пост с указанным идентификатором не найден, верните сообщение об этом с кодом 404. */

        /// Если postId не получилось извлечь — возвращаем 400 Bad Request
        if (postIdOpt.isEmpty()) {
            writeResponse(exchange, "Ошибка: неверный формат запроса", 400);
            return;
        }

        // получить id из postIdOpt
        int postId = postIdOpt.get();

        // список комментариев по postId из хранилища
        List<Comment> comments = commentsByPostId.get(postId);

        // нет комментариев
        if (comments == null || comments.isEmpty()){
            writeResponse(exchange, "", 200);
            return;
        }

        // строка-ответ: каждый комментарий с новой строки
        StringBuilder responseBuilder = new StringBuilder();
        for (Comment comment : comments) {
            responseBuilder.append(comment.toString()).append("\n");
        }

        // убрать последнюю строку
        String response = responseBuilder.toString().trim();

        writeResponse(exchange, response, 200);
    }

    private Optional<Integer> getPostId(HttpExchange exchange) {
        /* Реализуйте метод получения идентификатора поста.
           Если идентификатор не является числом, верните Optional.empty(). */
        /* Optional<T> — это обёртка вокруг значения. Ее задача - безопасно указывать, что значение может отсутствовать,
        без null и NullPointerException.*/
        // Разбиваем путь на части по символу "/"
        // ожидаемый шаблон: "/posts/123/comments" → ["", "posts", "123", "comments"]
        String path = exchange.getRequestURI().getPath();
        String[] parts = path.split("/");

        if (parts.length >= 4 && parts[1].equals("posts") && parts[3].equals("comments")) {
            try {
                // преобразовать часть, содержащую id в число
                int postId = Integer.parseInt(parts[2]);
                return Optional.of(postId);
            } catch (NumberFormatException e) {
                // Если {postId} не является числом, возвращаем пустой Optional
                return Optional.empty();
            }
        }
            // Если путь не соответствует ожидаемому шаблону — возвращаем пустой Optional
            return Optional.empty();

    }

    private void handlePostComments(HttpExchange exchange) throws IOException {
        writeResponse(exchange, "Этот эндпоинт пока не реализован", 200);
    }

    private Endpoint getEndpoint(String requestPath, String requestMethod) {
        String[] pathParts = requestPath.split("/");

        if (pathParts.length == 2 && pathParts[1].equals("posts")) {
            return Endpoint.GET_POSTS;
        }
        if (pathParts.length == 4 && pathParts[1].equals("posts") && pathParts[3].equals("comments")) {
            if (requestMethod.equals("GET")) {
                return Endpoint.GET_COMMENTS;
            }
            if (requestMethod.equals("POST")) {
                return Endpoint.POST_COMMENT;
            }
        }
        return Endpoint.UNKNOWN;
    }

    private void writeResponse(HttpExchange exchange,
                               String responseString,
                               int responseCode) throws IOException {
        try (OutputStream os = exchange.getResponseBody()) {
            exchange.sendResponseHeaders(responseCode, 0);
            os.write(responseString.getBytes(DEFAULT_CHARSET));
        }
        exchange.close();
    }

    enum Endpoint {GET_POSTS, GET_COMMENTS, POST_COMMENT, UNKNOWN}
}

public class Practicum {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // инициализация начальных данных
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post(1, "Это первый пост, который я здесь написал.");
        post1.addComment(new Comment("Пётр Первый", "Я успел откомментировать первым!"));
        posts.add(post1);

        Post post2 = new Post(22, "Это будет второй пост. Тоже короткий.");
        posts.add(post2);

        Post post3 = new Post(333, "Это пока последний пост.");
        posts.add(post3);

        // настройка и запуск HTTP-сервера
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/posts", new PostsHandler(posts));
        httpServer.start(); // запускаем сервер

        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
        // завершаем работу сервера для корректной работы тренажёра
        httpServer.stop(1);
    }
}

class Post {
    private int id;
    private String text;
    private List<Comment> comments = new ArrayList<>();

    public Post(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", comments=" + comments +
                '}';
    }
}

class Comment {
    private String user;
    private String text;

    public Comment(String user, String text) {
        this.user = user;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "user='" + user + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}