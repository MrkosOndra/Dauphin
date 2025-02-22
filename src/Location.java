import java.util.HashSet;

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
        return "Location{" +
                "name='" + name + '\'' +
                ", connections=" + connections +
                '}';
    }
}
