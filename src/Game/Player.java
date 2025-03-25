package Game;

import World.Item;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private ArrayList<Item> inventory;
    private int citizens;
    private boolean HasWon;

    /**
     * Třída reprezentuje hráče ve hře. Uchovává inventář, stav výhry a počet získaných obyvatel.
     * @author Ondra
     */
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

    /**
     * Přidá předmět do hráčova inventáře.
     * @param item Předmět, který se přidá
     */
    public void addItem(Item item) {
        if (item == null) {
            System.out.println("Nemůžeš přidat neexistující předmět!");
            return;
        }
        inventory.add(item);
        System.out.println("Sebral jsi: " + item.getName());
    }
    /**
     * Zjistí, zda hráč má konkrétní předmět.
     * @param ItemName Název hledaného předmětu
     * @return true, pokud hráč má daný předmět
     */
    public boolean hasItem(String ItemName){
        return inventory.stream().anyMatch(item-> item.getName().equalsIgnoreCase(ItemName));
    }
    /**
     * Vypíše všechny předměty v hráčově inventáři.
     */
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
    /**
     * Přičte hráči nové obyvatele.
     * @param count počet obyvatel k přičtení
     */
    public void addCitiziens(int count){
        this.citizens+=count;
        System.out.println("Pocet priznivcu zvysen o:"+ count +". Celkem mas: "+ citizens);

        if(citizens>=5000000){
            winGame();
        }
    }
    /**
     * Nastaví hráče jako vítěze a vypíše vítěznou zprávu do konzole.
     */
    public void winGame() {
        this.HasWon = true;
        System.out.println("Gratuluji! Dokončil jsi hru!");
    }
/**
 * Odstraní předmět z hráčova inventáře podle jeho názvu (bez ohledu na velikost písmen).
 * @param itemName Název předmětu, který se má odebrat
 */
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
