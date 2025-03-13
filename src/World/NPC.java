package World;

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
        System.out.println(name+ ": " + dialogue);
    }

    public Task giveTask() {
        if (!tasks.isEmpty()) {
            return tasks.get(0);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getDialogue() {
        return dialogue;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
