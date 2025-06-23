import java.util.Scanner;

public class CheckPrinterImproved {

    private static int findMaxLength(String[] elements) {
        int max = 0;
        for (String e : elements) {
            if (e.length() > max) {
                max = e.length();
            }
        }
        return max;
    }

    public static void printCheck(String[] items) {
        String[] names = new String[items.length];
        String[] counts = new String[items.length];
        String[] prices = new String[items.length];

        // Разделение строк по запятой
        for (int i = 0; i < items.length; i++) {
            String[] parts = items[i].split(",\\s*");
            names[i] = parts[0];
            counts[i] = parts[1];
            prices[i] = parts[2];
        }

        // Находим максимальные длины для выравнивания
        int maxNameLength = findMaxLength(names);
        int maxCountLength = findMaxLength(counts);

        // Печать строк с выравниванием через форматирование
        for (int i = 0; i < items.length; i++) {
            String line = String.format("%-" + maxNameLength + "s  %-" + maxCountLength + "s  %s",
                    names[i], counts[i], prices[i]);
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество записей:");
        int n = Integer.parseInt(scanner.nextLine());
        String[] values = new String[n];
        for (int i=0; i<n; ++i)
            values[i] = scanner.nextLine();
        printCheck(values);
    }
}