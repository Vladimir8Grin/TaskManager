import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EpicTest {

    @Test
    public void testGetSubTasks() {
        String[] subTasks = {"Task1", "Task2", "Task3"};
        Epic epic = new Epic(1, subTasks);

        String[] result = epic.getSubTasks();

        Assertions.assertArrayEquals(subTasks, result);
    }

    @Test
    public void testMatchesTrue() {
        String[] subTasks = {"Task1", "Task2", "Task3"};
        Epic epic = new Epic(1, subTasks);

        boolean result = epic.matches("Task2");

        Assertions.assertTrue(result);
    }

    @Test
    public void testMatchesFalse() {
        String[] subTasks = {"Task1", "Task2", "Task3"};
        Epic epic = new Epic(1, subTasks);

        boolean result = epic.matches("Task4");

        Assertions.assertFalse(result);
    }
}
