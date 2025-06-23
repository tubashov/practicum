package task_manager_05.controllers;

import task_manager_05.model.Task;
import task_manager_05.model.Epic;
import task_manager_05.model.SubTask;
import task_manager_05.util.Status;

import java.util.ArrayList;

public interface TaskManager {
    int generateId();

    Task addTask(Task task);

    Epic addTask(Epic epic);

    SubTask addTask(SubTask subTask);

    // получение списка всех задач
    ArrayList<task_manager_05.model.Task> getTasks();

    ArrayList<SubTask> getSubTasks();

    ArrayList<Epic> getEpics();

    // получение по идентификатору

    Task getTask(int idTask);

    Epic getEpic(int idEpic);

    SubTask getSubTask(int idSubTask);

    // список подзадач определенного эпика
    ArrayList<SubTask> getSubTaskList(int epicId);

    // обновление задачи
    void updateTask(task_manager_05.model.Task task);

    void updateEpic(Epic epic);

    void updateSubTask(SubTask subTask);

    void getHistory();

    // удаление всех задач
    void deleteTasks();

    void deleteEpics();

    void deleteSubTasks();

    // удаление по идентификатору
    void removeTask(int id);

    void removeEpic(int epicId);

    void removeSubTask(int id);

    // изменение статуса эпика
    Status updateEpicStatus(int epicId);
}
