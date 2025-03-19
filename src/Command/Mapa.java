package Command;

import World.WorldMap;
import World.Location;

public class Mapa extends Command {
    public Mapa(WorldMap map) {
        super(map);
    }

    @Override
    public void execute(String[] args) {
        System.out.println(" Mapa světa:");
        for (Location loc : map.getAllLocations()) {
            System.out.println(loc.getName() + " -> " + loc.getConnections().keySet());
        }
    }


    @Override
    public boolean exit() {
        return false;
    }
}
