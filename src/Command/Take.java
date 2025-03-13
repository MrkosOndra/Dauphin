package Command;

import World.Item;
import World.Location;
import World.WorldMap;

public class Take extends Command {
    public Take(WorldMap map) {
        super(map);
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Použití: take <předmět>");
            return;
        }
        String itemName = args[1].toLowerCase();
        Location currentLocation = map.getCurrentLocation();
        Item item = currentLocation.getItem(itemName);

        if(item!=null){
            map.getPlayer().addItem(item);
            currentLocation.removeItem(itemName);
            System.out.println("sebral jsi:"+ item.getName());
        }else{
            System.out.println("tento item zde neni");
        }
    }

        @Override
        public boolean exit () {
            return false;
        }
    }

