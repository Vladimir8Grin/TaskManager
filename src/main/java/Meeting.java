import java.util.Objects;

public class Meeting extends Task {
    private String topic;
    private String progect;
    private String start;

    public Meeting(int id, String topic, String progect, String start) {
        super(id);
        this.topic = topic;
        this.progect = progect;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }

    public String getProgect() {
        return progect;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        } else if (progect.contains(query)) {
            return true;
        } else {
            return false;
        }
    }
}
