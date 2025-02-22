import java.util.HashSet;
import java.util.stream.Collectors;

public class Location {
    private String name;
    private HashSet<Location> connections;

    public Location(String name) {
        this.name = name;
        this.connections = new HashSet<>();
    }

    public void addConnections(Location location){
        connections.add(location);
        location.connections.add(this);
    }

    public String getName() {
        return name;
    }

    public HashSet<Location> getConnections() {
        return connections;
    }

    @Override
    public String toString() {
        String connectedNames = connections.stream()
                .map(Location::getName)
                .collect(Collectors.joining(", "));
        return name + " -> [" + connectedNames + "]";
    }
}
