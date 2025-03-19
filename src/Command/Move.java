package Command;

import World.Location;
import World.WorldMap;

public class Move extends Command {
    private java.util.Arrays Arrays;

    public Move(WorldMap map) {
        super(map);
    }

    @Override
    public void execute(String[] args) {
        if(args.length < 2) {
            System.out.println("Použití: move <místo>");
            return;
        }

        String destination = String.join(" ", Arrays.copyOfRange(args, 1, args.length)).toLowerCase().trim();

        Location currentLocation= map.getCurrentLocation();
        if (currentLocation == null) {
            System.out.println("Chyba: Startovní lokace není nastavena! Zkontroluj World.txt.");
            return;
        }

            Location nextLocation = currentLocation.getConnections().get(destination);

            if (nextLocation != null) {
                map.setCurrentLocation(nextLocation);
                currentLocation = nextLocation;
                System.out.println("Přesunul si se do: " + currentLocation.getName());

                System.out.println("🔍 Hledám NPC v lokaci: " + currentLocation.getName());
                System.out.println("🗺️ Seznam NPC: " + currentLocation.getNpcs().keySet());


                if(!nextLocation.getNpcs().isEmpty()){
                    System.out.println("Muzes mluvit s: ");
for (String npcName: nextLocation.getNpcs().keySet()){
               System.out.println(npcName);
}
                }else{
                    System.out.println("tady nejsou npc se kterymi muzes mluvit");
                }
            } else {
                System.out.println("Tudy cesta nevede");
            }


    }

    @Override
    public boolean exit() {
        return false;
    }
}
