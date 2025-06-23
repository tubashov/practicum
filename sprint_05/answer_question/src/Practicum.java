import java.util.ArrayList;
import java.util.HashMap;

public class Practicum {

    public static void main(String[] args) {
        AnswerHolder<Number> elephantAnswer = new AnswerHolder<>("Сколько весит слон в тоннах", 5);
        elephantAnswer.printSmart();  // объект elephantAnswer

        HashMap<String, Double> bigRussianEncyclopedia = new HashMap<>(); // объект bigRussianEncyclopedia
        bigRussianEncyclopedia.put("Сколько часов в сутках", (double) 24);
        bigRussianEncyclopedia.put("Сколько весит слон в тоннах", 4.3);

        elephantAnswer.replaceAnswer(bigRussianEncyclopedia);
        elephantAnswer.printSmart();

        HardQuestion elephantVolumeQuestion = new HardQuestion("Как вычислить объём слона с помощью подручных средств?");
        elephantVolumeQuestion.printSmart();

        ArrayList<SmartPrintable> printables = new ArrayList<>();
        printables.add(elephantAnswer);
        printables.add(elephantVolumeQuestion);
        System.out.println("Всё, что можно распечатать: ");
        print(printables);

        ArrayList<AnswerHolder<Number>> answers = new ArrayList<>(); // answers - список с лучшими ответами на вопросы
        answers.add(elephantAnswer);
        System.out.println("Лучшие ответы на вопросы: ");
        print(answers);
    }

    ...

    void print(...values) { /// печть объектов разных типов
        for (...){
            value.printSmart();
        }
    }
}

interface SmartPrintable {
    void printSmart();
}

class AnswerHolder extends SmartPrintable {
        ...question;
intValue.answer;

public AnswerHolder(...) {
        ...
}

public void replaceAnswer(HashMap) {
    //метод должен замещать значение answer значением, полученным из аргумента - хеш-таблицы, для данного вопроса
        ...
}

@Override
public void printSmart() {
    System.out.println("Ответ на вопрос '" + question + "' равен " + answer.intValue());
}
}

class HardQuestion extends SmartPrintable {
        ...questionText;

public HardQuestion(...) {
        ...
}

@Override
public void printSmart() {
    System.out.println("Текст очень сложного вопроса: " + questionText);
}
}