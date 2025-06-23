package test_task_manager_05;

import org.junit.Test;
import task_manager_05.controllers.*;
import task_manager_05.model.Task;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ManagersTest {

    @Test
    public void testTaskManager() {
        TaskManager manager = new InMemoryTaskManager();

        assertNotNull(manager, "Задачи не найдена.");
        assertEquals(InMemoryTaskManager.class, manager.getClass());
    }

    @Test
    public void testHistoryManager() {
        InMemoryHistoryManager manager = new InMemoryHistoryManager();

        Task task = new Task();
        manager.add(task);
        final List<Task> history = manager.getHistory();

        assertNotNull(history, "После добавления задачи история не должна быть пустой.");
        assertEquals(1, history.size(), "После добавления задачи их количество должно соотвествовать.");
    }
}

