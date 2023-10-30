import java.util.Objects;

public class Epic extends Task {
    private String[] subTasks;

    public Epic(int id, String[] subTasks) {
        super(id);
        this.subTasks = subTasks;
    }

    public String[] getSubTasks() {
        return subTasks;
    }

    @Override
    public boolean matches(String query) {
        for (String subTasks : subTasks) {
            if (subTasks.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
