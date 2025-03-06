import java.util.HashMap;
import java.util.stream.Collectors;

public class Location {
    private String name;
    private HashMap<String,Location> connections;
    private HashMap<String,NPC> npcs;

    public Location(String name) {
        this.name = name;
        this.connections = new HashMap<>();
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

    public HashMap<String, Location> getConnections() {
        return connections;
    }

    @Override
    public String toString() {
        return name + " ->" + connections.keySet();
    }
}
