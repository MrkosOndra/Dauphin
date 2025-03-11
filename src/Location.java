import java.util.HashMap;
import java.util.stream.Collectors;

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

    public void addConnections(Location location){
        connections.put(location.getName().toLowerCase(), location);
        location.connections.put(this.name.toLowerCase(), this);
    }
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
}
