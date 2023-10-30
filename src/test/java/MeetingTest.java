import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MeetingTest {
    //Полирнуть перед отправкой!

    @Test
    public void testMatchesWhenQueryMatchesTopicReturnsTrue() {
        Meeting meeting = new Meeting(1, "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean result = meeting.matches("Выкатка");

        Assertions.assertTrue(result);
    }


    @Test
    public void testMatchesWhenQueryMatchesProjectReturnsTrue() {
        Meeting meeting = new Meeting(1, "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean result = meeting.matches("Приложение");

        Assertions.assertTrue(result);
    }


    @Test
    public void testMatchesWhenQueryDoesNotMatchReturnsFalse() {
        Meeting meeting = new Meeting(1, "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");


        boolean result = meeting.matches("Test");

        Assertions.assertFalse(result);
    }
}
