import java.util.List;

public class Player {
    private List<Item> inventory;
    private int citizens;
    private boolean HasWon;

    public Player(List<Item> inventory, int citizens, boolean hasWon) {
        this.inventory = inventory;
        this.citizens = citizens;
        HasWon = hasWon;
    }

    public Player() {
this.citizens=0;
this.HasWon=false;
    }


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
        System.exit(0);
    }

    public boolean hasWon() {
        return HasWon;
    }
}
