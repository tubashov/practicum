import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

class PostsHandler implements HttpHandler {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // получаем метод и путь запроса
        String requestPath = exchange.getRequestURI().getPath();
        String requestMethod = exchange.getRequestMethod();

        // получите информацию об эндпоинте, к которому был запрос
        Endpoint endpoint = getEndpoint(requestPath, requestMethod);

        switch (endpoint) {
            case GET_POSTS: {
                writeResponse(exchange, "Получен запрос на получение постов", 200);
                break;
            }
            case GET_COMMENTS: {
                writeResponse(exchange, "Получен запрос на получение комментариев", 200);
                break;
            }
            case POST_COMMENT: {
                writeResponse(exchange, "Получен запрос на добавление комментария", 200);
                break;
            }
            default:
                writeResponse(exchange, "Такого эндпоинта не существует", 404);
        }
    }

    // Определение типа эндпоинта
    private Endpoint getEndpoint(String requestPath, String requestMethod) {
        // реализуйте этот метод, проанализировав путь и метод запроса
        // Удалим ведущие и завершающие слэши, разделим путь
        String[] parts = requestPath.replaceAll("^/+", "").split("/");

        if (parts.length == 1 && parts[0].equals("posts") && requestMethod.equals("GET")) {
            return Endpoint.GET_POSTS;
        } else if (parts.length == 3 && parts[0].equals("posts") && parts[2].equals("comments")) {
            if (requestMethod.equals("GET")) {
                return Endpoint.GET_COMMENTS;
            } else if (requestMethod.equals("POST")) {
                return Endpoint.POST_COMMENT;
            }
        }
        return Endpoint.UNKNOWN;
    }

    // Отправка ответа
    private void writeResponse(HttpExchange exchange,
                               String responseString,
                               int responseCode) throws IOException {
            /*
             Реализуйте отправку ответа, который содержит responseString в качестве тела ответа
             и responseCode в качестве кода ответа.
             Учтите, что если responseString — пустая строка, то её не нужно передавать в ответе.
             В этом случае ответ отправляется без тела.
             */
            // если строка пустая — отправляем только статус
            if (responseString == null || responseString.isEmpty()) {
                exchange.sendResponseHeaders(responseCode, -1); // отправка заголовка без тела
                return;
            }

            // преобразование строки в байты
            byte[] responseBytes = responseString.getBytes(DEFAULT_CHARSET);
            exchange.sendResponseHeaders(responseCode, responseBytes.length);

            // отправка тела ответа
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
    }

    enum Endpoint {GET_POSTS, GET_COMMENTS, POST_COMMENT, UNKNOWN}
}

public class Practicum {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {

        // добавьте код для конфигурирования и запуска сервера
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);

        // Регистрируем обработчик на путь /posts
        httpServer.createContext("/posts", new PostsHandler());

        // Запускаем сервер
        httpServer.start();
        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
        // завершаем работу сервера для корректной работы тренажёра
        httpServer.stop(1);
    }
}