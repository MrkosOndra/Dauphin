package World;

import Game.Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Třída reprezentuje herní mapu, lokace a hráče.
 * Obsahuje metody pro načítání světa a NPC.
 * @author Ondra
 */
public class WorldMap {
private HashMap<String,Location> locations;
private Location currentLocation;
private String startLocation;
private Player player;

    public WorldMap() {
        locations = new HashMap<>();
        player = new Player();
    }

    public Player getPlayer() {
        return player;
    }
    /**
     * Načte mapu ze souboru World.txt
     * @return true, pokud načtení proběhlo úspěšně
     */
    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("World.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length < 2) continue;

                String locName = parts[0].trim().toLowerCase();
                Location loc = locations.computeIfAbsent(locName, name -> new Location(name));

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

    /**
     * Načte NPC ze souboru NPC.txt a přidá je do lokací.
     */
    public void loadNPCs() {
        try (BufferedReader br = new BufferedReader(new FileReader("NPC.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) continue;
                String[] parts = line.split(";");
                if (parts.length < 8) {
                    System.out.println(" Chyba v řádku: " + line);
                    continue;
                }

                String name = parts[0].trim();
                String locationName = parts[1].trim().toLowerCase();
                String dialogue = parts[2].trim();
                String taskDescription = parts[3].trim();
                String requiredItemName = parts[4].trim();
                String giverInfo = parts[5].trim();
                String rewardName = parts[6].trim();
                int populationGain = Integer.parseInt(parts[7].trim());

                Item requiredItem = new Item(requiredItemName);
                Item rewardItem = new Item(rewardName);
                Task task = new Task(taskDescription, requiredItem, rewardItem, populationGain);

                Location location = locations.get(locationName);
                if (location == null) {
                    System.out.println("Chyba: Lokace '" + locationName + "' pro NPC '" + name + "' neexistuje.");
                    continue;
                }



                NPC npc = new NPC(name, location, dialogue, task);
                location.addNpc(npc);

            }
        } catch (IOException e) {
            System.out.println("Chyba při načítání NPC: " + e.getMessage());
        }
    }
    public void printMap(){
        for(Location loc: locations.values()){
            System.out.println(loc);
        }
        }
    /**
     * Nastaví počáteční lokaci hráče ve světě podle jména zadané lokace.
     *
     * @param locationName Název startovní lokace (nerozlišuje velikost písmen).
     */
    public void setStartLocation(String locationName) {
        locationName = locationName.trim().toLowerCase();
        if (locations.containsKey(locationName)) {
            currentLocation = locations.get(locationName);
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
    /**
     * Přidá danou NPC postavu do zadané lokace na mapě.
     *
     * @param locationName název lokace, do které se má NPC přidat
     * @param npc objekt NPC, který má být přidán do lokace
     */
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
    public Collection<Location> getAllLocations() {
        return locations.values();
    }
}



