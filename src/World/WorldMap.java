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
    public void loadNPCs() {
        System.out.println("📥 Začínám načítat NPC z NPC.txt...");
        try (BufferedReader br = new BufferedReader(new FileReader("NPC.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) continue;
                System.out.println("📖 Čtu řádek: " + line);
                String[] parts = line.split(";");
                System.out.println("🔍 Parsuji: " + Arrays.toString(parts));
                if (parts.length < 8) {
                    System.out.println("⚠️ Chyba v řádku: " + line);
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
                    System.out.println("⚠️ Chyba: Lokace '" + locationName + "' pro NPC '" + name + "' neexistuje.");
                    continue;
                }


                System.out.println("🔍 Přidávám NPC: " + name + " do lokace: " + location.getName());


                NPC npc = new NPC(name, location, dialogue, task);
                location.addNpc(npc);


                System.out.println("✅ NPC '" + name + "' bylo úspěšně přidáno do lokace '" + location.getName() + "'");
                System.out.println("🗺️ NPC v lokaci " + location.getName() + ": " + location.getNpcs().keySet());
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
    public Collection<Location> getAllLocations() {
        return locations.values();
    }
}



