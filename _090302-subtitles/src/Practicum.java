import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Перечисление языков субтитров-строгая типизация и автозаполнение
enum SubtitleLanguage {
    ru, en, cn
}

// Реплика в субтитрах
class SubtitleItem {
    // Сопоставление языка и текста фразы
    private Map<SubtitleLanguage, String> values;
    // время начала отображения субтитра
    private LocalTime begin;
    // Время окончания отображения субтитра
    private LocalTime end;

    public SubtitleItem(Map<SubtitleLanguage, String> values, LocalTime begin, LocalTime end) {
        this.values = values;
        this.begin = begin;
        this.end = end;
    }

    public Map<SubtitleLanguage, String> getValues() {
        return values;
    }

    public void setValues(Map<SubtitleLanguage, String> values) {
        this.values = values;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(LocalTime begin) {
        this.begin = begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    // Переопределяем equals для сравнения объектов SubtitleItem по содержимому
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // если объекты одинаковы по ссылке
        if (!(obj instanceof SubtitleItem)) return false; // если объект не нужного типа
        SubtitleItem other = (SubtitleItem) obj;
        // сравнение полей values, begin и end
        return Objects.equals(values, other.values) &&
                Objects.equals(begin, other.begin) &&
                Objects.equals(end, other.end);
    }

    // Переопределяем hashCode для корректной работы коллекций и сравнения
    @Override
    public int hashCode() {
        return Objects.hash(values, begin, end);
    }
}

class SubtitleListTypeToken {
    public Type getType() {
        return new TypeToken<List<SubtitleItem>>() {}.getType();
    }
}

// Кастомный адаптер для сериализации/десериализации LocalTime
class LocalTimeTypeAdapter extends TypeAdapter<LocalTime> {
    // Формат времени: чч:мм:сс.миллисекунды
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    // Преобразование времени в строку при сериализации
    @Override
    public void write(final JsonWriter jsonWriter, final LocalTime localTime) throws IOException {
        jsonWriter.value(localTime.format(formatter));
    }
    // Преобразуем локальное время в строку по формату "HH:mm:ss.SSS"
    @Override
    public LocalTime read(JsonReader in) throws IOException {
        String str = in.nextString();
        return LocalTime.parse(str, formatter);
    }
}

public class Practicum {
    public static void main(String[] args) {
        List<SubtitleItem> subtitles = Arrays.asList(
                new SubtitleItem(Map.of(
                        SubtitleLanguage.ru, "Здравствуйте!",
                        SubtitleLanguage.en, "Hello!",
                        SubtitleLanguage.cn, "Ni hao"
                ), LocalTime.of(0, 0, 15), LocalTime.of(0, 0, 17)),

                new SubtitleItem(Map.of(
                        SubtitleLanguage.ru, "Привет!",
                        SubtitleLanguage.en, "Hi!",
                        SubtitleLanguage.cn, "Ni hao"
                ), LocalTime.of(0, 0, 21), LocalTime.of(0, 0, 24)),

                new SubtitleItem(Map.of(
                        SubtitleLanguage.ru, "Как дела?",
                        SubtitleLanguage.en, "How are you?",
                        SubtitleLanguage.cn, "Ni hao ma"
                ), LocalTime.of(0, 0, 28), LocalTime.of(0, 0, 31)),

                new SubtitleItem(Map.of(
                        SubtitleLanguage.ru, "Всё хорошо, спасибо!",
                        SubtitleLanguage.en, "I'm fine, thank you!",
                        SubtitleLanguage.cn, "Wo hen hao, xie xie"
                ), LocalTime.of(0, 0, 34), LocalTime.of(0, 0, 37))
        );

        // Создаём билдер для Gson
        GsonBuilder gsonBuilder = new GsonBuilder();

        // Регистрируем адаптер для обработки времени LocalTime
        gsonBuilder.registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter());

        gsonBuilder.enableComplexMapKeySerialization();

        // Включаем pretty-print — отступы и переносы строк
        gsonBuilder.setPrettyPrinting();

        // Создаём экземпляр Gson с нужными настройками
        Gson gson = gsonBuilder.create();

        // Сериализуем список субтитров в строку JSON
        String subtitlesJson = gson.toJson(subtitles);
        System.out.println("Сериализованные субтитры:");
        System.out.println(subtitlesJson);

        // Определяем тип результата: список элементов SubtitleItem
        Type type = new SubtitleListTypeToken().getType();

        LocalTime time = LocalTime.of(9, 5, 7, 123_000_000);
        String result = time.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        System.out.println(result);

        // Парсим строку JSON обратно в список объектов
        List<SubtitleItem> parsed = gson.fromJson(subtitlesJson, type);

        // Сравниваем оригинальные и распарсенные данные
        if (parsed.equals(subtitles)) {
            System.out.println("Субтитры десериализованы корректно.");
        } else {
            System.out.println("Произошла ошибка при десериализации.");
        }
    }
}
