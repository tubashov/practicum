public class Practicum {
    public static void main(String[] args) {
        String pixelKcalDay = "43"; // столько калорий съел Пиксель до похода к бабушке
        String beefKcal = "30.2"; // калорийность говядины
        String chickenKcal = "23.8"; // калорийность курицы
        String creamKcal = "32.1"; // калорийность сливок
        String milkKcal = "13.5"; // калорийность молока

        Float firstDishKcal = Float.parseFloat(beefKcal);
        Float secondDishKcal = Float.parseFloat(chickenKcal);
        Float firstDesert = Float.parseFloat(creamKcal);
        Float secondDesert = Float.parseFloat(milkKcal);

        float pixelChoice = getMinKcalsSum(firstDishKcal, secondDishKcal, firstDesert, secondDesert);
        float totalKcal = Float.parseFloat(pixelKcalDay) + pixelChoice;
        checkKcal(totalKcal);
    }

    private static Float getMinKcalsSum(Float firstDishKcal, Float secondDishKcal, Float firstDesert, Float secondDesert) {
        float minDishKcal = Float.min(firstDishKcal, secondDishKcal); // вычислите минимальную калорийность основного блюда
        float minDesertKcal = Float.min(firstDishKcal,  secondDesert); // вычислите минимальную калорийность десерта
        return minDishKcal + minDesertKcal;
    }

    private static void checkKcal(float catKcal) {
        if (catKcal == 0.0) {
            System.out.println("Что-то пошло не так");
        } else {
            System.out.println("Калорийность рациона Пикселя за день: " + catKcal);
            if (catKcal > 100) {
                System.out.println("Пиксель сегодня не уложился в норму.");
            } else {
                System.out.println("Лимит не превышен!");
            }
        }
    }
}
