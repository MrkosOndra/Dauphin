import java.util.HashSet;

public class Location {
    private String name;
    private HashSet<Location> connections;

    public Location(String name) {
        this.name = name;
        this.connections = new HashSet<>();
    }
}
