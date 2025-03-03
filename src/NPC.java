import java.util.List;

public class NPC {
    private String name;
    private Location location;
    private String dialogue;
    private List<Task> tasks;

    public NPC(String name, Location location, String dialogue, List<Task> tasks) {
        this.name = name;
        this.location = location;
        this.dialogue = dialogue;
        this.tasks = tasks;
    }

    public void talk() {
        System.out.println(dialogue);
    }

    public Task giveTask() {

        return null;
    }
}
