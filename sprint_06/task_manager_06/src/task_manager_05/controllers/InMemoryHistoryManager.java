package task_manager_05.controllers;

import task_manager_05.model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    public InMemoryHistoryManager() {

    }

    private List<Task> history = new ArrayList<>();

    // просмотр истории
    @Override
    public void add(Task task) {
        if (task == null) {
            return;
        }
        history.add(task);
        if (history.size() > 10) {
            history.remove(0);
        }
    }
    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }
}
