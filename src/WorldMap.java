import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WorldMap {
private HashMap<String,Location> locations;
private Location currentLocation;

    public WorldMap() {
        locations = new HashMap<>();
    }

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("World.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length < 2) continue;

                String locName = parts[0].trim();
                Location loc = locations.computeIfAbsent(locName, name -> new Location(name));

                for (int i = 1; i < parts.length; i++) {
                    String connectedLocName = parts[i].trim();
                    Location connectedLoc = locations.computeIfAbsent(connectedLocName, name -> new Location(name));
                    loc.addConnections(connectedLoc);
                }
            }
            String startLocation = "Pariz";
            if (locations.containsKey(startLocation)) {
                currentLocation = locations.get(startLocation);
                System.out.println(" Startovní lokace nastavena: " + currentLocation.getName());
            }
            return true;
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
        locationName = locationName.toLowerCase();
        if (locations.containsKey(locationName)) {
            currentLocation = locations.get(locationName);
            System.out.println("Startovní lokace nastavena: " + currentLocation.getName());
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
}


