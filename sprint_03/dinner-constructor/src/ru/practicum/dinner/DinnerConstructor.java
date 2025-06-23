package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishes;
    DinnerConstructor() { dishes = new HashMap<>();}

    Random random = new Random();

    boolean checkType(String type) {
        boolean chek = dishes.containsKey(type);
        return chek;
    }
    void addNewType(String dishType) {
        // добавьте новое блюдо
        dishes.put(dishType, new ArrayList<>());
    }
    void addNewDish(String dishType, String dishName) {
        // добавьте новое блюдо
         dishes.get(dishType).add(dishName);
         return;
    }
    void configurationDishCombo(int numberOfCombos, ArrayList<String> dishType) {
        if (dishType.isEmpty()) {
            System.out.println("Тип блюда не выбран.");
        } else {
            for(int i = 0; i < numberOfCombos; ++i) {
                System.out.println("Для набора Комбо №" + (i + 1) + " предлагаются следующие блюда:");

                for(int j = 0; j < dishType.size(); ++j) {
                    String type = (String)dishType.get(j);
                    int bound = dishes.get(type).size();
                    int chooseId = random.nextInt(bound);
                    String dish = dishes.get(type).get(chooseId);
                    System.out.print(dish + " ");
                }

                System.out.println();
            }

        }
    }
}
