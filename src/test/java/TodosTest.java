import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {
    @Test
    public void TestAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subTasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subTasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void PhraseMatchTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить кошачие пакетики");

        String[] subTasks = {"Молоко", "Яйца", "Хлеб", "кошачие пакетики"};
        Epic epic = new Epic(55, subTasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("кошачие");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWithAnEmptyArray() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить");

        String[] subTasks = {"Молоко", "Яйца", "Хлеб", "кошачие пакетики"};
        Epic epic = new Epic(55, subTasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("");
        Assertions.assertArrayEquals(expected, actual);
    }
}