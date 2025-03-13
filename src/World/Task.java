package World;

import Game.Player;

public class Task {
    private String description;
    private boolean complete;
    private Item requiredItem;
    private Item reward;
    private int citizensReward;

    public Task(String description, boolean complete, Item requiredItem, Item reward, int citizensReward) {
        this.description = description;
        this.complete = complete;
        this.requiredItem = requiredItem;
        this.reward = reward;
        this.citizensReward = citizensReward;
    }

    public boolean checkCompletion(Player player) {
        if (player.hasItem(requiredItem.getName())) {
            complete = true;
            return true;
        }

        return false;
    }

    public boolean isComplete() {
        return complete;
    }

    public Item getRequiredItem() {
        return requiredItem;
    }

    public int getCitizensReward() {
        return citizensReward;
    }

    public Item getReward() {
        return reward;
    }

    public String getDescription() {
        return description;
    }
}
