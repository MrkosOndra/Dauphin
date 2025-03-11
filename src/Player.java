import java.util.List;

public class Player {
    private List<Item> inventory;

    public Player(List<Item> inventory, boolean hasWon) {
        this.inventory = inventory;
        this.HasWon = false;
    }

    private boolean HasWon;


    public void addItem(Item item) {
        inventory.add(item);
        System.out.println("sebral jsi: "+ item.getName());

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
    public void winGame() {
        this.HasWon = true;
        System.out.println("Gratuluji! Dokončil jsi hru!");
    }

    public boolean hasWon() {
        return HasWon;
    }
}
