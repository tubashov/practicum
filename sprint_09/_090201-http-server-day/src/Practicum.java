import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Random;
import java.time.DayOfWeek;


public class Practicum {
    private static final int PORT = 8080;

    // IOException могут сгенерировать методы create() и bind(...)
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create();

        httpServer.bind(new InetSocketAddress(PORT), 0); // связываем сервер с сетевым портом
        httpServer.createContext("/hello", new HelloHandler()); // связываем путь и обработчик
        // добавьте новый обработчик для /day тут
        httpServer.createContext("/day", new DayHandler());

        httpServer.start(); // запускаем сервер

        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
        httpServer.stop(1); // завершение сервера необходимо для тренажёра
    }

    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println("Началась обработка /hello запроса от клиента.");

            String response = "Hey! Glad to see you on our server.";
            httpExchange.sendResponseHeaders(200, 0); // возвращаем HTTP-ответ с кодом 200 OK и не указываем размер сообщения

            try (OutputStream os = httpExchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
    // объявите класс-обработчик тут
    static class DayHandler implements HttpHandler {
        // Здесь вы можете объявить переменные и методы для обработки запроса
        Random random = new Random();
        int rndDayNumber = random.nextInt(7) + 1;
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            // Логика обработки запроса будет здесь
            System.out.println("Началась обработка /day запроса от клиента.");


            String randomDay = DayOfWeek.of(rndDayNumber).name(); // получаем имя дня недели
            httpExchange.sendResponseHeaders(200, 0); // возвращаем HTTP-ответ с кодом 200 OK и не указываем размер сообщения

            try (OutputStream os = httpExchange.getResponseBody()) {
                os.write(randomDay.getBytes());
            }
        }
    }
}