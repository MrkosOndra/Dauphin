public class Task {
    private String description;
    private boolean complete;
    private Item requiredItem;
    private Item reward;

    public Task(String description, Item requiredItem, Item reward) {
        this.description = description;
        this.complete = false;
        this.requiredItem = requiredItem;
        this.reward = reward;
    }

    public boolean checkCompletion(Player player) {

        return false;
    }

    public Item getReward() {
        return reward;
    }

    public String getDescription() {
        return description;
    }
}
