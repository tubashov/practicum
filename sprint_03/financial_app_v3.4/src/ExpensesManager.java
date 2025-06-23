import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
    }

    double saveExpense(double moneyBeforeSalary, String category, double expense) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            expenses.add(expense);
        } else {
            ArrayList<Double> expenses = new ArrayList<>();
            expenses.add(expense);
            expensesByCategories.put(category, expenses);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;

        void printAllExpensesByCategories() {
            for (String category : expensesByCategories.keySet()) {
                System.out.println(category);
                ArrayList<Double> expenses = expensesByCategories.get(category);
                for (Double expense : expenses) {
                    System.out.println(expense);
                }
            }
        }

        double findMaxExpenseInCategory(String category) {
            double maxExpense = 0;
            if (expensesByCategories.containsKey(category)) {
                ArrayList<Double> expenses = expensesByCategories.get(category);
                for (Double expense : expenses) {
                    if (expense > maxExpense) {
                        maxExpense = expense;
                    }
                }
            } else {
                System.out.println("Такой категории пока нет.");
            }
            return maxExpense;
        }

        void removeAllExpenses() {
            expensesByCategories.clear();
            System.out.println("Траты удалены.");
        }

        double getExpensesSum() { // напишите метод для получения суммы всех трат
            double sumExpenses = 0;
            //for (String category : expensesByCategories.keySet()) {
            for (ArrayList<Double> expenses : expensesByCategories.values()) {
                for (Double expense : expenses) {
                    sumExpenses += expense;
                }
            }
            //}
            return sumExpenses;
        }

        void removeCategory(String category) { // напишите метод для удаления категории
            expensesByCategories.remove(category);
        }

        String getMaxCategoryName() { // напишите метод для получения категории, где размер трат больше всего
            // используйте эти переменные для сохранения промежуточных значений
            double maxCategorySum = 0;

            String maxCategoryName = "";

            for (String category : expensesByCategories.keySet()) { // обход по всем категориям (ключам хэштаблицы)
                ArrayList<Double> expenses = expensesByCategories.get(category); // создаем список (динамический массив)
                // с расходами для каждой категории
                double categorySum = 0;

                for (Double expense : expenses) { // считаем расходы для каждой категории
                    categorySum += expense;
                }
                if (maxCategorySum < categorySum) { // если расходы по категории максимальные,
                    maxCategorySum = categorySum;
                    maxCategoryName = category;     // отмечаем категорию как категорию с максимальными расходами
                }
            }
            return maxCategoryName;
        }
    }

