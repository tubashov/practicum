package test_task_manager_05;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import task_manager_05.controllers.InMemoryTaskManager;
import task_manager_05.model.Epic;
import task_manager_05.model.SubTask;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static task_manager_05.util.Status.NEW;

public class SubTaskTest {

    static InMemoryTaskManager inMemoryTaskManager;

    @BeforeAll
    static void beforeAll() {
        inMemoryTaskManager = new InMemoryTaskManager();
    }

    @Test
    public void testSubTaskEqualsSubTask() {

        SubTask subTask = new SubTask(1, "Test addSubTask name",
                "Test addSubTask description", NEW);

        final int subTaskId = subTask.getId();

        final SubTask savedSubTask = inMemoryTaskManager.getSubTask(subTaskId);

        assertEquals(subTask, savedSubTask, "Задачи не совпадают.");
    }

    @Test
    public void testSubTaskNotEqualsEpic() {

        SubTask subTask = new SubTask(1, "Test addSubTask name", "Test addSubTask description",
                NEW );
        inMemoryTaskManager.addTask(subTask);

        Epic epic = new Epic(1, "Test addEpic name", "Test addEpic description", NEW);
        inMemoryTaskManager.addTask(epic);

        ArrayList<SubTask> subTasks = inMemoryTaskManager.getSubTasks();
        ArrayList<Epic> epics = inMemoryTaskManager.getEpics();

        assertNotEquals(subTasks.get(0), epics.get(0), "Задачи совпадают.");

    }
}