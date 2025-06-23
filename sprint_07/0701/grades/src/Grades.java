public class Grades {
    public static void main(String[] args) {
        gradeBeautifier("вероника,чехова,ФИЗИКА,5;анна,строкова,МАТЕМАТИКА,4;иван,петров,ГЕОМЕТРИЯ,5");
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static String gradeToString(String grade) {
        switch (grade) {
            case "5": {
                return "Безупречно";
            }
            case "4": {
                return "Потрясающе";
            }
            case "3": {
                return "Восхитительно";
            }
            case "2": {
                return "Прекрасно";
            }
            default:
                return "Очаровательно";
        }
    }

    // grades - строка вида "имя,фамилия,предмет,оценка;имя,фамилия,предмет,оценка;"
    public static void gradeBeautifier(String grades) {
        // реализуйте метод здесь
        String[] strOne = grades.split(";"); // разбивка на строки по разделителю ;

        for (String str : strOne) {
            if (str.isEmpty()) {
                continue;
            }
            String[] info = str.split(",");

            String firstName = capitalize(info[0]);
            String lastName = capitalize(info[1]);
            String subject = info[2].toLowerCase();
            String grade = gradeToString(info[3]);
            System.out.println(firstName + " " + lastName + " " +  subject + " - " + grade);
        }
    }
}