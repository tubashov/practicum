import java.util.ArrayList;

public class Forest {
    private ArrayList<MountainHare> hares;
    // объявите недостающие переменные и добавьте конструктор

    private static String season;

    static String color;

    // добавьте метод setSeason(String newSeason)
    // в этом методе реализуйте логику смены цвета шубок зайцев-беляков
    static void setSeason(String newSeason) {
        if (newSeason == "зима") {
            color = "белый";
        } else {
            color = "серо-рыжий";
        }
    }

    // добавьте метод printHares()
    void printHares(ArrayList<MountainHare> hares) {
        for (MountainHare hare : hares)
            System.out.println(hare);
    }
}
