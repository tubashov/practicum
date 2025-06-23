class MonthData { // Логика по подсчёту статистики за месяц; хранение данных конкретного месяца
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() { // Количество пройденных шагов по дням
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() { // Общее количество шагов за месяц
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    int maxSteps() { // Максимальное количество шагов за месяц
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (maxSteps < days[i])
                maxSteps = days[i];
        }
        return maxSteps;
    }
    int bestSeries(int goalByStepsPerDay) { //  Лучшая серия: количество шагов за день было равно или выше целевого
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}
