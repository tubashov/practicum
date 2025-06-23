package task_manager_05.controllers;

public class Managers {

    Managers manager = new Managers();

    public TaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
}
