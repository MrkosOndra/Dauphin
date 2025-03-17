package Command;

import World.WorldMap;

public class Inventory extends Command{
    public Inventory(WorldMap map) {
        super(map);
    }

    @Override
    public void execute(String[] args) {
map.getPlayer().printInventory();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
