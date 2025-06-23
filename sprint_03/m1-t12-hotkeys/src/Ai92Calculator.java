public class Ai92Calculator {
    double Ai92Calculator = 42.74;
    double tax = 0.13;
    double fullPrice = Ai92Calculator * (1 + tax);

    public double calculate(double volume) {
        return volume * fullPrice;
    }
}
