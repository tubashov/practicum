class Converter {
    int convertToKm(int steps) { // метод, который переводит количество шагов в километры // static !!!
        int distance = (int) (steps * 0.75 / 1000);

        return distance;
    }

    int convertStepsToKilocalories(int steps) { // метод, который переводит количество шагов в килокалории static
        int kkal = (int) (steps * 50 / 1000);

        return kkal;
    }
}
