import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Написать другу");
        boolean actual = simpleTask.matches("позвонить");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Написать другу");
        boolean actual = simpleTask.matches("Написать");
        Assertions.assertTrue(actual);

    }

    @Test
    public void testEmptyArray() {
        SimpleTask simpleTask = new SimpleTask(1, "");
        boolean actual = simpleTask.matches("");
        Assertions.assertTrue(actual);
    }
}