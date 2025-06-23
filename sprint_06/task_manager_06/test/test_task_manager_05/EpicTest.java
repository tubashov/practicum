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

    class EpicTest {
        static InMemoryTaskManager inMemoryTaskManager;

        @BeforeAll
        static void beforeAll() {
            inMemoryTaskManager = new InMemoryTaskManager();
        }

        @Test
        public void testEpicEqualsEpic() {
            //InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();
            Epic epic = new Epic(1, "Test addEpic name", "Test addEpic description", NEW);

            final int epicId = epic.getId();

            final Epic savedEpic = inMemoryTaskManager.getEpic(epicId);

            assertEquals(epic, savedEpic, "Задачи не совпадают.");
        }

        @Test
        public void testEpicNotEqualsSubTask() {
            //InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();
            Epic epic = new Epic(1, "Test addEpic name", "Test addEpic description", NEW);
            inMemoryTaskManager.addTask(epic);

            SubTask subTask = new SubTask(1, "Test addSubTask name", "Test addSubTask description", NEW );
            inMemoryTaskManager.addTask(subTask);

            ArrayList<Epic> epics = inMemoryTaskManager.getEpics();
            ArrayList<SubTask> subTasks = inMemoryTaskManager.getSubTasks();

            assertNotEquals(epics.get(0), subTasks.get(0), "Задачи совпадают.");

        }
    }