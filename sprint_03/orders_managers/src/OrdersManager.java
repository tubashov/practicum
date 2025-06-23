import java.util.ArrayList;
import java.util.HashMap;

public class OrdersManager {
    HashMap<String, ArrayList<Double>> customersOrders;

    public OrdersManager() {
        customersOrders = new HashMap<>();
        ArrayList<Double> orders = new ArrayList<>();
        orders.add(154.43);
        orders.add(5453.98);
        orders.add(8776.65);
        customersOrders.put("Иван И.", orders);

        orders = new ArrayList<>();
        orders.add(25343.54);
        orders.add(420.50);
        customersOrders.put("Ольга С.", orders);

        orders = new ArrayList<>();
        orders.add(325.90);
        customersOrders.put("Александр Т.", orders);

        orders = new ArrayList<>();
        orders.add(253.54);
        orders.add(420.50);
        customersOrders.put("Александр Р.", orders);

        orders = new ArrayList<>();
        orders.add(780.54);
        orders.add(420.50);
        orders.add(36343.54);
        orders.add(2000.50);
        customersOrders.put("Екатерина О.", orders);
    }

    void printAllOrders() {
        for (String name : customersOrders.keySet()) { // цикл должен пройтись по ключам
            System.out.println("Заказы " + name + ":");
            ArrayList<Double> value = customersOrders.get(name);
            System.out.println(value);
        }
    }

    double getOrdersSum() {
        double sum = 0;
        for (ArrayList<Double> orders : customersOrders.values()) { // здесь должен быть обход по значениям
            for (double orderPrice : orders) {
                sum += orderPrice;
            }
        }
        return sum;
    }

    void printCustomerOrders(String customerName) {
        if (customersOrders.containsKey(customerName) == true) { // проверьте, есть ли указанный ключ в таблице
            System.out.println("Заказы " + customerName + ":");
            System.out.println(customersOrders.get(customerName));
        }
    }

    String getMaxOrderCustomerName() {
        double maxOrder = 0;
        String customerName = "";

        for (String name : customersOrders.keySet()) {// допишите логику работы метода
            ArrayList<Double> orders = customersOrders.get(name);

            double sumOrders = 0;

            for (double order : orders) {
                sumOrders += order;
            }
            if (sumOrders > maxOrder) {
                maxOrder = sumOrders;
                customerName = name;
            }
        }
        return customerName;
    }

    void removeUnprofitableOrders() {
        ArrayList<String> names = new ArrayList<>(); // создайте список клиентов с заказами меньше 5000

        for (String name : customersOrders.keySet()) {

            double ordersSum = 0;

            for (double order : customersOrders.get(name)) {
                ordersSum += order;
            }
            if (ordersSum < 5000) {
                names.add(name); // наполните список names
            }
        }

        for (String name : names) {  // удалите из хеш-таблицы тех, чьи расходы строго меньше 5000
                 customersOrders.remove(names);

            System.out.println("Клиента " + name + " больше нет в таблице.");
        }

    }
}