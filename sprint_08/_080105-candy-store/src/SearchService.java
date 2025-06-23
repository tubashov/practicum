import java.util.Comparator;
import java.util.Optional;

public class SearchService {
    private final Warehouse warehouse = new Warehouse();
    public final SRM srm = new SRM();

    public Optional<Candy> search(String candyName) {
        return warehouse.search(candyName)
                .or(() -> supplierSearch(candyName));
    }

    private Optional<Candy> supplierSearch(String candyName) {
        return srm.listSuppliers().stream()
                .map(supplier -> Optional.ofNullable(srm.getProduct(supplier, candyName)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .min(Comparator.comparing(c -> c.price));
    }
}
