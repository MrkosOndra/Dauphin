package Command;

import World.WorldMap;

public class Status extends Command{
    public Status(WorldMap map) {
        super(map);
    }

    @Override
    public void execute(String[] args) {
        System.out.println("pocet Priznivcu:" + map.getPlayer().getCitizens());
    }

    @Override
    public boolean exit() {
        return false;
    }
}
