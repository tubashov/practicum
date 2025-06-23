package task_manager_05.controllers;

import task_manager_05.model.Epic;
import task_manager_05.model.SubTask;
import task_manager_05.model.Task;
import task_manager_05.util.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {
    private int count;

    private HistoryManager historyManager = new InMemoryHistoryManager();

    // коллекция для хранения всех типов
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, SubTask> subTasks = new HashMap<>();


    @Override
    public int generateId() {
        count++;
        return count;
    }

    @Override
    public Task addTask(Task task) {
        int id = generateId();
        task.setId(id);
        this.tasks.put(id, task);
        return task;
    }
    @Override
    public Epic addTask(Epic epic) {
        int id = generateId();
        epic.setId(id);
        this.epics.put(id, epic);
        return epic;
    }
    @Override
    public SubTask addTask(SubTask subTask) {
        int id = generateId();
        subTask.setId(id);
        this.subTasks.put(id, subTask);
        return subTask;
    }
    // получение списка всех задач
    @Override
    public ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public ArrayList<SubTask> getSubTasks() {
        return new ArrayList<>(subTasks.values());
    }

    @Override
    public ArrayList<Epic> getEpics() {
        return new ArrayList<>(epics.values());
    }
    // получение по идентификатору
    @Override
    public Task getTask(int idTask) {
        final Task task = tasks.get(idTask);
        if (task == null) {
            return null;
        }
        historyManager.add(task);
        return task;
    }
    @Override
    public Epic getEpic(int idEpic) {
        final Epic epic = epics.get(idEpic);
        if (epic == null) {
            return null;
        }
        historyManager.add(epic);
        return epic;
    }
    @Override
    public SubTask getSubTask(int idSubTask) {
        final SubTask subTask = subTasks.get(idSubTask);
        if (subTask == null) {
        return null;
        }
        historyManager.add(subTask);
        return subTask;
    }
    // список подзадач определенного эпика
    @Override
    public ArrayList<SubTask> getSubTaskList(int epicId) {
        ArrayList<SubTask> listSubTasks = new ArrayList<>();
        Epic epic = this.epics.get(epicId);
        List<Integer> subTaskIds = epic.getIdSubTask();
        for (Integer subTaskId : subTaskIds) {
            SubTask subTask =  subTasks.get(subTaskId);
            listSubTasks.add(subTask);
        }
        return listSubTasks;
    }
    // обновление задачи
    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateEpic(Epic epic) {
        tasks.put(epic.getId(), epic);
    }

    @Override
    public void updateSubTask(SubTask subTask) {
        this.subTasks.put(subTask.getId(), subTask);
        Integer idEpic = subTask.getEpicId();
        Epic epic = epics.get(idEpic);
        Status status = updateEpicStatus(idEpic);
        epic.setStatus(status);
    }

    public void updateHistory(Task task){
        historyManager.add(task);
    }

    @Override
    public void getHistory() {
        historyManager.getHistory();
    }

    // удаление всех задач
    @Override
    public void deleteTasks() {
        tasks.clear();
    }

    @Override
    public void deleteEpics() {
        epics.clear();
        subTasks.clear();
    }

    @Override
    public void deleteSubTasks() {
        for (Epic epic : epics.values()) {
            epic.cleanSubtaskIds();
            updateEpicStatus(epic.getId());
        }
        subTasks.clear();
    }
    // удаление по идентификатору
    @Override
    public void removeTask(int id) {
        tasks.remove(id);
    }

    @Override
    public void removeEpic(int epicId) {
        Epic epic = this.epics.get(epicId);
        List<Integer> subTaskIds =  epic.getIdSubTask();
        for (Integer subTaskId : subTaskIds) {
            subTasks.remove(subTaskId);
        }
        epics.remove(epicId);
    }
    @Override
    public void removeSubTask(int id) {
        Integer epicId = subTasks.get(id).getEpicId();
        subTasks.remove(id);
        Epic epic = epics.get(epicId);
        epic.removeSubtaskIds(id);
        Status status = updateEpicStatus(epicId);
        epic.setStatus(status);
    }

    // изменение статуса эпика
    @Override
    public Status updateEpicStatus(int epicId){
        int newCount = 0;
        int doneCount = 0;
        Epic epic = this.epics.get(epicId); // создаем объект класса epic с epicId, поступившего в параметре метода
        List<Integer> subTaskIds = epic.getIdSubTask(); // создаем список idSubtask из этого epica
        for(Integer subTaskId : subTaskIds) { // обход всех элементов списка
            SubTask subTask = this.subTasks.get(subTaskId); // перебор всех подзадач из хэш-таблицы subTasks
            if (subTask.getStatus() == Status.NEW) { // если статус подзадачи в хэш -таблице совпадает со статусом
                newCount++;                          // подзадачи рассматриваемог epica, срабатывает счетчик
            } else if (subTask.getStatus() == Status.DOWN) {
                doneCount++;
            }
        }
        if (subTaskIds.size() == newCount) { // определяем по счетчикам статус epica
            return Status.NEW;
        } else if (subTaskIds.size() == doneCount) {
            return Status.DOWN;
        } else {
            return Status.IN_PROGRESS;
        }
    }
}
