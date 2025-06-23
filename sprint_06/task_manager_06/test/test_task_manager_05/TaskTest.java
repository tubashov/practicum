package test_task_manager_05;

import org.junit.jupiter.api.Test;
import task_manager_05.controllers.InMemoryTaskManager;
import task_manager_05.model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static task_manager_05.util.Status.NEW;

class TaskTest {

    @Test
    public void testTaskEqualsTask() {
        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();
        Task task = new Task("Test addNewTask", "Test addNewTask description", NEW);

        final int taskId = task.getId();

        final Task savedTask = inMemoryTaskManager.getTask(taskId);

        assertEquals(task, savedTask, "Задачи не совпадают.");
    }
}