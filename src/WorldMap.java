import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WorldMap {
private HashMap<String,Location> locations;
private Location currentLocation;
private String startLocation;

    public WorldMap() {
        locations = new HashMap<>();
    }

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("World.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length < 2) continue;

                String locName = parts[0].trim().toLowerCase();
                Location loc = locations.computeIfAbsent(locName, name -> new Location(name));

                System.out.println("nactena lokace:"+ locName);

                for (int i = 1; i < parts.length; i++) {
                    String connectedLocName = parts[i].trim().toLowerCase();
                    Location connectedLoc = locations.computeIfAbsent(connectedLocName, name -> new Location(name));
                    loc.addConnections(connectedLoc);
                }
            }
            return !locations.isEmpty();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void printMap(){
        for(Location loc: locations.values()){
            System.out.println(loc);
        }
        }
    public void setStartLocation(String locationName) {
        locationName = locationName.trim().toLowerCase();
        if (locations.containsKey(locationName)) {
            currentLocation = locations.get(locationName);
            System.out.println("Startovní lokace nastavena: " + currentLocation.getName());
        }else{
            System.out.println("Chyba: Startovní lokace '" + locationName + "' neexistuje!");
        }
        }


    public Location getStartingLocation(){
        return locations.values().iterator().next();
    }


    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
    public void addNPCLocation(String locationName, NPC npc){
        Location location = locations.get(locationName.toLowerCase());
        if (location != null) {
            location.addNpc(npc);
        } else {
            System.out.println("Chyba: Lokace '" + locationName + "' neexistuje.");
        }
    }

    public NPC GetNPCbyName(String NpcName) {
        for (Location loc : locations.values()) {
            NPC npc = loc.getNPC(NpcName);
            if (npc != null) {
                return npc;
            }
        }
        return null;
    }

}



