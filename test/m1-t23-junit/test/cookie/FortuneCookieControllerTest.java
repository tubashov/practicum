package cookie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FortuneCookieControllerTest {

    static FortuneCookieController goodFactoryController;
    static FortuneCookieController badFactoryController;

    static FortuneCookieFactory factory;

    public static FortuneCookieController create(boolean isPositive) {
        FortuneConfig fortuneConfig = new FortuneConfig(isPositive);
        ArrayList<String> positive = new ArrayList<>();
        positive.add("positive");
        ArrayList<String> negative = new ArrayList<>();
        negative.add("negative");
        factory = new FortuneCookieFactory(fortuneConfig, positive, negative);
        FortuneCookieController fortuneCookieController = new FortuneCookieController(factory);
        return fortuneCookieController;
    }
    @BeforeAll
    public static void beforeAll() {
        goodFactoryController = create(true);
        badFactoryController = create(false);
    }
    @Test
    public void shouldReturnPositiveFortune() {
        String fortune = goodFactoryController.tellFortune().getFortuneText();
        Assertions.assertEquals("positive", fortune);
    }
    @Test
    public void shouldReturnNegativeFortune() {
        String fortune = badFactoryController.tellFortune().getFortuneText();
        Assertions.assertEquals("negative", fortune);
    }
}