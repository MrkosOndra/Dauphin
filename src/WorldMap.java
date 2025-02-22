import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WorldMap {
private HashMap<String,Location> locations;

    public WorldMap() {
        locations = new HashMap<>();
    }

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("World.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length > 2) continue;

                String locName = parts[0].trim();
                Location loc = locations.computeIfAbsent(locName, name -> new Location(name));

                for (int i = 1; i < parts.length; i++) {
                    String connectedLocName = parts[i].trim();
                    Location connectedLoc = locations.computeIfAbsent(connectedLocName, name -> new Location(name));
                    loc.addConnections(connectedLoc);
                }
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
    }

