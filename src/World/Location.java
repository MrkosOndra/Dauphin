package World;

import java.util.HashMap;
/**
 * Třída reprezentuje lokaci na mapě.
 * Obsahuje napojení na další lokace, NPC a itemy v lokaci.
 * @author Ondra
 */
public class Location {
    private String name;
    private HashMap<String,Location> connections;
    private HashMap<String,NPC> npcs;
    private HashMap<String,Item> Items;

    public Location(String name) {
        this.name = name;
        this.connections = new HashMap<>();
        this.npcs=new HashMap<>();
        this.Items=new HashMap<>();
    }
    /**
     * Přidá spojení mezi touto lokací a jinou.
     * @param location Lokace, která se připojí
     */
    public void addConnections(Location location){
        connections.put(location.getName().toLowerCase(), location);
        location.connections.put(this.name.toLowerCase(), this);
    }
    /**
     * Přidá NPC do lokace.
     * @param npc NPC objekt
     */
    public void addNpc( NPC npc){
        npcs.put(npc.getName().toLowerCase(),npc);
    }
    public NPC getNPC(String name){
        return npcs.get(name.toLowerCase());
    }

    public String getName() {
        return name;
    }
    public void addItem(Item item) {
        Items.put(item.getName().toLowerCase(), item);
    }

    public Item getItem(String itemName) {
        return Items.get(itemName.toLowerCase());
    }

    /**
     * Odstraní item z lokace.
     * @param itemName název itemu
     */
    public void removeItem(String itemName) {
        Items.remove(itemName.toLowerCase());
    }

    public HashMap<String, Location> getConnections() {
        return connections;
    }

    @Override
    public String toString() {
        return name + " ->" + connections.keySet();
    }

    public HashMap<String, NPC> getNpcs() {
        return npcs;
    }
}
