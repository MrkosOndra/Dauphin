package Command;

import World.WorldMap;

public class Exit extends Command {
    public Exit(WorldMap map) {
        super(map);
    }

    @Override
    public void execute(String[] args) {
        System.out.println("hra ukoncena");
        System.exit(0);

    }

    @Override
    public boolean exit() {
        return true;
    }
}
