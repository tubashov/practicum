import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;

// Обработчик запросов на путь /hello
class HelloHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response;

        // Получаем HTTP-метод (GET, POST и т.д.)
        String method = httpExchange.getRequestMethod();

        switch (method) {
            case "POST":
                // Обработка POST-запроса
                response = handlePostRequest(httpExchange);
                break;
            case "GET":
                // Обработка GET-запроса
                response = handleGetRequest(httpExchange);
                break;
            default:
                // Обработка других методов — возвращаем сообщение об ошибке
                response = "Некорректный метод!";
                byte[] errorBytes = response.getBytes(StandardCharsets.UTF_8);
                httpExchange.sendResponseHeaders(405, errorBytes.length); // 405 Method Not Allowed
                try (OutputStream os = httpExchange.getResponseBody()) {
                    os.write(errorBytes); // Пишем тело ответа
                }
                return; // Завершаем выполнение
        }

        // Отправляем успешный ответ
        byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
        httpExchange.sendResponseHeaders(200, responseBytes.length); // 200 OK
        try (OutputStream os = httpExchange.getResponseBody()) {
            os.write(responseBytes); // Пишем тело ответа
        }
    }

    // Метод обработки GET-запроса
    private static String handleGetRequest(HttpExchange httpExchange) {
        // Всегда возвращаем простое приветствие
        return "Здравствуйте!";
    }

    // Метод обработки POST-запроса
    private static String handlePostRequest(HttpExchange httpExchange) throws IOException {
        // Получаем путь запроса, например: /hello/программист/Егор
        String path = httpExchange.getRequestURI().getPath();

        // Удаляем "/hello/" и разбиваем оставшуюся часть на части
        String[] splitString = path.replaceFirst("/hello/", "").split("/");

        // Проверяем, что путь содержит профессию и имя
        if (splitString.length < 2) {
            return "Некорректный путь запроса!";
        }

        String profession = splitString[0]; // первая часть — профессия
        String name = splitString[1];       // вторая часть — имя

        // Считываем тело запроса (например, "Доброе утро")
        InputStream is = httpExchange.getRequestBody();
        String body = new String(is.readAllBytes(), StandardCharsets.UTF_8).trim();

        // Получаем заголовки запроса
        Headers headers = httpExchange.getRequestHeaders();

        // Извлекаем значение заголовка X-Wish-Good-Day
        List<String> wishGoodDay = headers.get("X-Wish-Good-Day");

        // Формируем приветствие: "[тело запроса], профессия имя!"
        StringBuilder response = new StringBuilder();
        response.append(body).append(", ").append(profession).append(" ").append(name).append("!");

        // Если передан заголовок X-Wish-Good-Day=true, добавляем пожелание
        if (wishGoodDay != null && wishGoodDay.contains("true")) {
            response.append(" Хорошего дня!");
        }

        // Возвращаем собранную строку
        return response.toString();
    }
}

// Главный класс сервера
public class Practicum {
    private static final int PORT = 8080; // Порт, на котором запускается сервер

    public static void main(String[] args) throws IOException {
        // Создаем HTTP-сервер на заданном порту
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);

        // Регистрируем обработчик на путь /hello
        httpServer.createContext("/hello", new HelloHandler());

        // Запускаем сервер
        httpServer.start();
        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");

        // НЕ нужно останавливать сервер сразу
        httpServer.stop(2);
    }
}
