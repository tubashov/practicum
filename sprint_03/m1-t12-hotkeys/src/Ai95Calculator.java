public class Ai95Calculator {
    double Ai95Calculator = 46.35;
    double tax = 0.14;
    double fullPrice = Ai95Calculator * (1 + tax);

    public double calculate(double volume) {
        return volume * fullPrice;
    }
}
