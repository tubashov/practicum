import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class Practicum {

    public static void main(String[] args) throws IOException, InterruptedException {
        // укажите URL-адрес ресурса
        URI url = URI.create("https://ya.ru/white");

        // получаем экземпляр класса-строителя
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder();

        // создайте объект, описывающий HTTP-запрос
        HttpRequest request = requestBuilder
                .GET() // метод запроса
                .uri(url) // указываем адрес ресурса
                .version(HttpClient.Version.HTTP_1_1) // указываем версию протокола HTTP
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7") // указываем заголовок Accept
                .build(); // заканчиваем настройку и создаём ("строим") HTTP-запрос

        // создайте HTTP-клиент с настройками по умолчанию
        HttpClient client = HttpClient.newHttpClient();

        // получите стандартный обработчик тела запроса
        // с конвертацией содержимого в строку
        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString() ;

        // отправьте запрос
        HttpResponse<String> response = client.send(request, handler);

        // выведите код состояния и тело ответа
        System.out.println("Код ответа: " + response.statusCode());
        System.out.println("Тело ответа: " + response.body());
    }
}