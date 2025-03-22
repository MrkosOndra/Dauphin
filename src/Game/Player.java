package Game;

import World.Item;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private ArrayList<Item> inventory;
    private int citizens;
    private boolean HasWon;

    public Player(ArrayList<Item> inventory, int citizens, boolean hasWon) {
        this.inventory = inventory;
        this.citizens = citizens;
        HasWon = hasWon;
    }

    public Player() {
        this.inventory=new ArrayList<>();
        this.citizens=0;
        this.HasWon=false;
    }


    public void addItem(Item item) {
        if (item == null) {
            System.out.println("Nemůžeš přidat neexistující předmět!");
            return;
        }
        inventory.add(item);
        System.out.println("Sebral jsi: " + item.getName());
    }
    public boolean hasItem(String ItemName){
        return inventory.stream().anyMatch(item-> item.getName().equalsIgnoreCase(ItemName));
    }

    public void printInventory() {
        if(inventory.isEmpty()){
            System.out.println("Tvuj inventar je prazdny");
        }else {
            System.out.println(" Tvůj inventář:");
            for (Item item : inventory) {
                System.out.println(" - " + item.getName());
            }
        }

    }
    public void addCitiziens(int count){
        this.citizens+=count;
        System.out.println("Pocet priznivcu zvysen o:"+ count +". Celkem mas: "+ citizens);

        if(citizens>=5000000){
            winGame();
        }
    }
    public void winGame() {
        this.HasWon = true;
        System.out.println("Gratuluji! Dokončil jsi hru!");
    }
    public void removeItem(String itemName) {
        inventory.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
        System.out.println("🗑️ Odevzdal jsi: " + itemName);
    }
    public boolean hasWon() {
        return HasWon;
    }

    public int getCitizens() {
        return citizens;
    }
}
