import java.util.ArrayList;
import java.util.List;

public class GradesReversed {

    private String gradeStringToInt(String grade) {
        switch (grade) {
            case "Безупречно": {
                return "5";
            }
            case "Потрясающе": {
                return "4";
            }
            case "Восхитительно": {
                return "3";
            }
            case "Прекрасно": {
                return "2";
            }
            default:
                return "1";
        }
    }

    public String serializeGrades(String[] grades) {

        // String[] list = new String[3];
        List<String> list = new ArrayList<>();
        for (String grade : grades) {
            // каждая строка массива разбивается на отдельный элемент ( разделитель " ")
            String[] gr = grade.split(" ");
            // объединение элементов нового массива в строки
            String firstName = gr[0].toLowerCase();
            String lastName = gr[1].toLowerCase();
            String subject = gr[2];
            String gradeText = gradeStringToInt(gr[4]);

            String str = String.join(",", firstName, lastName, subject, gradeText);
            // объединение строк в список
            list.add(str);
        }
        String serializeGrades = String.join(";", list);

        return serializeGrades;
    }

}