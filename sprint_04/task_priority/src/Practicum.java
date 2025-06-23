import java.util.ArrayList; // импортируйте нужные пакеты

public class Practicum {
    public static void main(String[] args) {

        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(TaskPriority.HIGH, "Оплатить интернет."));
        tasks.add(new Task(TaskPriority.LOW, "Сходить в парикмахерскую."));
        tasks.add(new Task(TaskPriority.MEDIUM, "Выбрать подарок подруге на ДР."));
        tasks.add(new Task(TaskPriority.MEDIUM, "Купить билеты в театр."));
        tasks.add(new Task(TaskPriority.HIGH, "Посетить вебинар по английскому языку."));
        tasks.add(new Task(TaskPriority.LOW, "Купить пылесос."));

        System.out.println("Задачи с наивысшим приоритетом на сегодня:");
        searchTask(tasks, TaskPriority.HIGH);
    }
        public static void searchTask(ArrayList<Task> tasks, TaskPriority taskPriority) {
            for (Task t : tasks) { // цикл for для поиска задач
                if (t.getPriority() == TaskPriority.HIGH) {
                    System.out.println(t.getDescription());
                }
            }
        }

}