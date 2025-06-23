import java.util.ArrayList;

public class Practicum {
    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Крокодил");
        animals.add("Слон");
        animals.add("Шиншилла");
        animals.add("Лев");
        animals.add("Медведь");

        System.out.println("Сегодня в зоопарке можно увидеть кормления " + animals.size() + " животных.");
        System.out.println("Это будут:");
        for (int i = 0; i < animals.size(); i++) {
            String animal = animals.get(i);
            System.out.println(animal);
        }
        System.out.println("Расписание кормлений:");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println("В " + (i + 9) + ":00 - " + animals.get(i));
        }
    }
}
