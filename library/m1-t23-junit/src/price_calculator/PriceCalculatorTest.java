package price_calculator;

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
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, 10) == 100);
    }
    @Test
    public void shouldBeNegativeWhenBikeAndDistanceIs20Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, 21) < 0);
    }

    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs0Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 0) <= 0);
    }
    @Test
    public void shouldReturn3500ForCarAndDistance500Km() {
        priceCalculator.calculatePrice(TransportType.CAR, 500);
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 500) == 3500);
    }
    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs1000Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 1001) < 0);
    }

    @Test
    public void shouldBeNegativeWhenTruckAndDistanceIs0Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.TRUCK, 0) <= 0);
    }
    @Test
    public void shouldReturn3500ForTruckAndDistance1000Km() {
        priceCalculator.calculatePrice(TransportType.TRUCK, 500);
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.TRUCK, 1000) == 5000);
    }
    @Test
    public void shouldBeNegativeWhenDrone() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.DRONE, 0) == null);
    }
}
