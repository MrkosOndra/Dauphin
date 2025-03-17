package World;

import Game.Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        try (BufferedReader br = new BufferedReader(new FileReader("NPC.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) continue; // Přeskočí komentáře a prázdné řádky

                String[] parts = line.split(";");
                if (parts.length < 8) {
                    System.out.println("⚠️ Chyba v řádku: " + line);
                    continue;
                }

                // Načtení dat z textového souboru
                String name = parts[0].trim();   // Jméno NPC
                String locationName = parts[1].trim().toLowerCase();  // Lokace NPC
                String dialogue = parts[2].trim();  // Co NPC říká hráči
                String taskDescription = parts[3].trim();  // Popis úkolu
                String requiredItemName = parts[4].trim();  // Požadovaný předmět
                String giverInfo = parts[5].trim();  // Kdo má požadovaný předmět
                String rewardName = parts[6].trim();  // Odměna
                int populationGain = Integer.parseInt(parts[7].trim());  // Počet získaných obyvatel

                Item requiredItem = new Item(requiredItemName);
                Item rewardItem = new Item(rewardName);

                Task task = new Task(taskDescription,requiredItem, rewardItem, populationGain);

                NPC npc = new NPC(name, locations.get(locationName), dialogue,task);

                // Přidání NPC do lokace
                if (locations.containsKey(locationName)) {
                    locations.get(locationName).addNpc(npc);
                    System.out.println("✅ Načteno NPC: " + name + " do lokace " + locationName);
                } else {
                    System.out.println("⚠️ Chyba: Lokace '" + locationName + "' pro NPC '" + name + "' neexistuje.");
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Chyba při načítání NPC: " + e.getMessage());
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



