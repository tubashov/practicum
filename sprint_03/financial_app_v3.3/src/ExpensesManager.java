import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories; // замените на таблицу

    // с именем expensesByCategories
    ExpensesManager() {
        expensesByCategories = new HashMap<>(); // создайте таблицу
    }

    // добавьте в метод ещё один параметр — category
    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        // замените на работу с таблицей
        if (expensesByCategories.containsKey(category)) { // проверьте наличие категории
            ArrayList<Double> expenses = expensesByCategories.get(category);// получите список трат в этой категории
            expenses.add(expense);// добавьте трату
        } else {
            ArrayList<Double> expenses = new ArrayList<>(); // создайте новый список трат и добавьте в него сумму
            expenses.add(expense);
            expensesByCategories.put(category, expenses); // сохраните категорию и новый список трат в хеш-таблицу
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }


    void printAllExpensesByCategories() { // траты по категориям
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            for (Double expens : expensesByCategories.get(category)) {
                System.out.println(expens);
            }
        }
    }

    double findMaxExpenseInCategory(String category) { // максимальная трата в категории
        double maxExpense = 0;
        /* Замените логику для работы с таблицами
        Если категория есть, то ищем максмальную трату.
        Иначе печатаем "Такой категории пока нет." */
        if (expensesByCategories.containsKey(category)) {
            for (Double expenses : expensesByCategories.get(category)) {
                if (expenses > maxExpense) {
                    maxExpense = expenses;
                }
            }
            return maxExpense;
        } else {
            System.out.println("Такой категории пока нет");
        }
        return maxExpense;
    }

    void removeAllExpenses() { // очистка всей таблицы трат
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }
}
