public class FindRepeats {
    int numberOfRepeats(String text, String substring) {
        int count = 0;
        if (text == null || substring == null || substring.isEmpty()) {
            return 0;
        }

        StringBuilder sb = new StringBuilder(text);

        while (true) {
            int index = sb.indexOf(substring); // ищем подстроку
            if (index == -1) {
                break; // совпадений больше нет
            }

            count++;
            // удаляем всё до конца найденной подстроки
            sb.delete(0, index + substring.length());
        }

        return count;
    }
}