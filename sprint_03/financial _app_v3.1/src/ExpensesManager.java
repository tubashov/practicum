import java.util.ArrayList;

public class ExpensesManager {
    // double[] expenses; // замените массив списком
    ArrayList<Double> expenses;

    ExpensesManager() {
        // expenses = new double [7]; // создайте список в конструкторе
        expenses = new ArrayList<>();
    }

    // номер дня больше не нужен
    double saveExpense(double moneyBeforeSalary, double expense) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        // expenses[day - 1] = expenses[day - 1] + expense; // эту строку нужно убрать
        expenses.add(expense);
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpenses() {
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println("Трата № " + (i + 1) + ". Потрачено " + expenses.get(i) + " рублей");
        }
    }

    double findMaxExpense() {
        double maxExpense = 0;
        // for (int i = 0; i < expenses.size(); i++) {
        // используйте сокращённую форму цикла
        for (Double exp: expenses) {
            if (exp > maxExpense) {
                maxExpense = exp;
            }
        }
        return maxExpense;
    }
}
