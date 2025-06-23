package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.println("Введите тип блюда:");
                    String dishType = scanner.nextLine();
                    System.out.println("Введите название блюда:");
                    String dishName = scanner.nextLine();
                    if (dc.checkType(dishType)) {
                        dc.addNewDish(dishType, dishName);
                    } else {
                        dc.addNewType(dishType);
                        dc.addNewDish(dishType, dishName);
                    }
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Работа программы завершена.");
                    return;
                default:
                    System.out.println("Такой команды нет.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");

        int numberOfCombos = Integer.parseInt(scanner.nextLine());

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

        ArrayList<String> dishType = new ArrayList<>();

        while (true) { //реализуйте ввод типов блюд
            String nextItem = scanner.nextLine();
            if (nextItem.isEmpty()) {
                System.out.println("Тип блюда не введён.");
                break;
            } else {
                if (!dc.checkType(nextItem)) {
                    System.out.println("Такого типа нет");
                } else {
                    dishType.add(nextItem); // добавление типа в массив типов блюд
                }
            }
        }
       dc.configurationDishCombo(numberOfCombos, dishType);
    }
}
