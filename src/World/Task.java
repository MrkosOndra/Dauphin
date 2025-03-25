package World;

import Game.Player;
/**
 * Třída reprezentuje úkol, který může hráč splnit.
 * Obsahuje požadovaný item, odměnu a počet obyvatel, které hráč získá za splnění.
 * @author Ondra
 */
public class Task {
    private String description;
    private boolean complete;
    private Item requiredItem;
    private Item reward;
    private int citizensReward;

    public Task(String description, Item requiredItem, Item reward, int citizensReward) {
        this.description = description;
        this.complete = false;
        this.requiredItem = requiredItem;
        this.reward = reward;
        this.citizensReward = citizensReward;
    }
    /**
     * Zkontroluje, zda hráč má požadovaný předmět pro splnění úkolu.
     * @param player hráč
     * @return true, pokud hráč má požadovaný item
     */
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
