package cookie;

public class FortuneController {

    private final FortuneCookieFactory fortuneCookieFactory;

    public FortuneController(FortuneCookieFactory fortuneCookieFactory) {
        this.fortuneCookieFactory = fortuneCookieFactory;
    }

    public FortuneCookie tellFortune() {
        return this.fortuneCookieFactory.bakeFortuneCookie();
    }
}
