public class Palindrome {
    public boolean isPalindromeLine(String str) {

        // Приводим строку к нижнему регистру
        str = str.toLowerCase();

        // Помещаем строку в StringBuilder
        StringBuilder sb = new StringBuilder(str);

        // Удаляем пробелы
        int i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == ' ') {
                sb.deleteCharAt(i);

            } else {
                i++;
            }
        }

        // Создаём копию и переворачиваем
        StringBuilder reverseSb = new StringBuilder(sb);
        reverseSb.reverse();
        return sb.toString().equals(reverseSb.toString());
    }
}