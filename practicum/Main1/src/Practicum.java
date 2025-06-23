import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Practicum {

    public static void main(String[] args) {

        // создаём список товаров
        List<Item> items = new ArrayList<>();
        items.add(new Item("Рубашка", 4500, 37));
        items.add(new Item("Носки", 55, 8));
        items.add(new Item("Толстовка", 1399, 74));
        items.add(new Item("Носки", 169, 19));

        System.out.println("До сортировки:");
        System.out.println(items);

        // создаём объект-компаратор по цене
        ItemPriceComparator itemPriceComparator = new ItemPriceComparator();

        // применяем компаратор
        items.sort(itemPriceComparator);

        System.out.println("После сортировки:");
        System.out.println(items);
    }


    static class Item {

        public final String name;
        public final int price;
        public final int popularity;

        public Item(String name, int price, int popularity) {
            this.name = name;
            this.price = price;
            this.popularity = popularity;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", popularity=" + popularity +
                    '}';
        }
    }

    static class ItemPriceComparator implements Comparator<Item> {

        @Override
        public int compare(Item item1, Item item2) {

            if (item1.price > item2.price) {
                return 1;

            } else if (item1.price < item2.price) {
                return -1;

            } else {
                return 0;
            }
        }
    }
}