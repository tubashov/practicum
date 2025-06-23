package task_manager_05.controllers;

import task_manager_05.model.Task;

import java.util.List;

public interface HistoryManager {

    void add(Task task); // отметка задачи как просмотренной

    List<Task> getHistory(); // возвращает список задач
}
