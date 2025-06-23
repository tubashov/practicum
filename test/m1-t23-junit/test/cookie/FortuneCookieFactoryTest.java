package cookie;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FortuneCookieFactoryTest {

    FortuneCookieFactory factory;

    @BeforeEach
    public void beforeEach() {
        boolean isPositive = true;
        FortuneConfig fortuneConfig = new FortuneConfig(isPositive);
        ArrayList<String> positive = new ArrayList<>();
        positive.add("positive");
        ArrayList<String> negative = new ArrayList<>();
        negative.add("negative");
        factory = new FortuneCookieFactory(fortuneConfig, positive, negative);
    }

    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked() {
        factory.bakeFortuneCookie();
        int count = factory.getCookiesBaked();
        Assertions.assertEquals(1, count);
    }
    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        factory.bakeFortuneCookie();
        factory.bakeFortuneCookie();
        int count = factory.getCookiesBaked();
        Assertions.assertEquals(2, count);
    }
    @Test
    public void shouldSetCounterToZeroAfterResetCookieCreatedCall() {
        factory.bakeFortuneCookie();
        int count = factory.getCookiesBaked();
        factory.resetCookiesCreated();
        count = factory.getCookiesBaked();
        Assertions.assertEquals(0, count);
    }
}