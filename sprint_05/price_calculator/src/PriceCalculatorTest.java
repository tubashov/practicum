import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PriceCalculatorTest {

    private final PriceCalculator priceCalculator = new PriceCalculator();

    @Test
    public void shouldBeNegativeWhenBikeAndDistanceIs0Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, 0) < 0);
    }
    @Test
    public void shouldReturn100ForBikeAndDistance10Km() {
        priceCalculator.calculatePrice(TransportType.BIKE, 10);
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, 0) == 100);
    }
    @Test
    public void shouldBeNegativeWhenBikeAndDistanceIs0Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, 0) > 20);
    }

    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs0Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 0) < 0);
    }
    @Test
    public void shouldReturn3500ForCarAndDistance500Km() {
        priceCalculator.calculatePrice(TransportType.CAR, 500);
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 0) == 500);
    }
    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs1000Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 0) > 1000);
    }

    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs0Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 0) < 0);
    }
    @Test
    public void shouldReturn3500ForCarAndDistance500Km() {
        int price =  priceCalculator.calculatePrice(10);
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 0) == 500);
    }
    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs1000Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 0) > 1000);
    }
}