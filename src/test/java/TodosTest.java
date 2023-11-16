import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {
    @Test
    public void multipleTasksFoundTest() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Задание про магазин"); // Находим несколько задач
        SimpleTask simpleTask2 = new SimpleTask(6, "Купить котлету в магазине");
        SimpleTask simpleTask3 = new SimpleTask(7, "Яйца и хлеб");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {simpleTask1, simpleTask2};
        Task[] actual = todos.search("магазин");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void singleTaskFoundTest() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Задание про магазин"); // Находим ровно одну задачу
        SimpleTask simpleTask2 = new SimpleTask(6, "Купить котлету в магазине");
        SimpleTask simpleTask3 = new SimpleTask(7, "Яйца и хлеб");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {simpleTask2};
        Task[] actual = todos.search("котлету");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void noTasksFoundTest() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Задание про магазин"); // не находим ни одной задачи
        SimpleTask simpleTask2 = new SimpleTask(6, "Купить котлету в магазине");
        SimpleTask simpleTask3 = new SimpleTask(7, "Яйца и хлеб");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {};
        Task[] actual = todos.search("морковка");
        Assertions.assertArrayEquals(expected, actual);
    }

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