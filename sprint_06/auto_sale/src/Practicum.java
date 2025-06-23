import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Practicum {
    public static void main(String[] args) {
        // ключ – автомобиль, значение – количество экземпляров
        Map<Car, Integer> cars = new TreeMap<>();

        // хеш-таблица заполняется данными
        cars.put(new Car("Audi A6", 3760000), 2);
        cars.put(new Car("Honda CR-V ", 2500000), 3);
        cars.put(new Car("KIA Cerato", 1300000), 8);
        cars.put(new Car("Volkswagen Tiguan", 1935000), 5);

        // проверяем порядок
        for (Car car : cars.keySet()) {
            System.out.println(car);
        }
    }
}

class Car implements Comparable<Car> {
    String model;
    Integer priceInRubles;

    public Car(String model, Integer priceInRubles) {
        this.model = model;
        this.priceInRubles = priceInRubles;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return model.equals(car.model);
    }

    public int hashCode() {
        return model.hashCode();
    }
    @Override
    public int compareTo(Car o) {
        return this.priceInRubles - o.priceInRubles;
    }
    public String toString() {
        return "Car{model=" + model + ", priceInRubles=" + priceInRubles + "}";
    }


}