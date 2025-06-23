import java.util.Optional;

public class Practicum {
    public static void main(String[] args) {
        SearchService searchService = new SearchService();

        String searchQuery = "Африка";
        Optional<Candy> result = searchService.search(searchQuery);

        if (result.isPresent()) {
            Candy candy = result.get();
            System.out.println("Товар \"" + candy.name + "\" доступен в количестве " +
                    candy.amount + " кг по цене " + candy.price + " руб за кг");
        } else {
            System.out.println("Данный товар не найден.");
        }
    }
}
