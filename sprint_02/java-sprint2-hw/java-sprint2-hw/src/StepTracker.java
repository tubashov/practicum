import java.util.Scanner;

class StepTracker { // Логика по сохранению количества шагов (ввод месяца, дня, количества шагов и сохранение
    // данных); логика по изменению ежедневной нормы шагов; вывод статистики
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();

    int goalByStepsPerDay = 10000; // цель п умолчанию: колическтво шагов за день

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() { // ввод пройденного количества шагов в день
        System.out.println("Введите номер месяца от 1 до 12");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Введен некорректный номер месяца");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Введен некорректный номер дня");
            return;
        }
        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("Введено неправильное число");
            return;
        }

        MonthData monthData = monthToData[month - 1]; // получение соответствующего объекта MonthData из массива
        monthData.days[day - 1] = steps; // Сохранение полученных данных - шагов в параметр days класса MonthDat
    }

    void changeStepGoal() { // Изменение цели шагов на день
        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("Введено неправильное число");
            return;
        }
        this.goalByStepsPerDay = steps; // можно без this
    }

    void printStatistic() {
        System.out.println("Введите число месяца от 1 до 12");
        int month = scanner.nextInt();
        if (month < 1 || month > 12){
            System.out.println("Введен некорректный номер месяца");
            return;
        }
        monthToData[month - 1].printDaysAndStepsFromMonth(); // Количество пройденных шагов по дням
        int sumSteps = monthToData[month - 1].sumStepsFromMonth(); // Общее количество шагов за месяц
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        int maxSteps = monthToData[month - 1].maxSteps(); // Максимальное количество шагов в месяце
        System.out.println("Максимальное количество шагов в месяце: " + maxSteps);
        System.out.println("Среднее количество шагов за месяц: " + sumSteps / 30); // Среднее количество шагов за месяц
        int distans = converter.convertToKm(sumSteps); // Пройденная дистанция в километрах  за месяц
        System.out.println("Пройденная дистанция в километрах  за месяц: " + distans);
        int kkal = converter.convertStepsToKilocalories(sumSteps); // Количество сожжённых килокалорий за месяц
        System.out.println("Количество сожжённых килокалорий за месяц: " + kkal);
        int finalSeries =  monthToData[month - 1].bestSeries(goalByStepsPerDay); //  Лучшая серия
        System.out.println("Лучшая серия: " + finalSeries);

    }
}
