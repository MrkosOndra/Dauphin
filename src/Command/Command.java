package Command;
import World.Location;
import World.WorldMap;
import World.WorldMap.*;

public abstract class Command {
    protected WorldMap map;
    protected Location currentLocation;

    public Command(WorldMap map) {
        this.map = map;
    }
    public abstract void execute(String[] args);
    public abstract boolean exit();
}
