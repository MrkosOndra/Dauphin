package Game;

import Command.Command;
import World.Item;
import World.WorldMap;
import Command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Start {
    private WorldMap world;
    private Map<String, Command> commands;
    private Scanner scanner;

    public Start() {
        this.scanner = new Scanner(System.in);
        this.world = new WorldMap();
        this.commands = new HashMap<>();

        commands.put("move", new Move(world));
        commands.put("exit", new Exit(world));
        commands.put("talk", new Talk(world));
        commands.put("take", new Take(world));
        commands.put("complete", new Complete(world));
        commands.put("help", new Help(world));
        commands.put("inventory",new Inventory(world));
        commands.put("status",new Status(world));
        commands.put("map",new Mapa(world));
    }

    public void run() {
        if (world.loadMap()) {
            world.printMap();
            world.setStartLocation("Orleans");
            world.loadNPCs();
            System.out.println("═══════════════════════════════════");
            System.out.println("🎉 Vítej ve hře *Dauphin*! 🎉");
            System.out.println("🗺️ Nacházíš se v městě *Orléans*.");
            System.out.println("📜 Jmenuješ se *Dauphin* a tvým úkolem je sjednotit království.");
            System.out.println("🎒 V inventáři máš důležitý předmět pro svůj první úkol.");
            Item startingItem = new Item("Magic Stone");
            world.getPlayer().addItem(startingItem);
            System.out.println("🎒 Můžeš kdykoli zadat 'help' pro seznam příkazů nebo 'map' pro zobrazení mapy.");
            System.out.println("👉 Tvým prvním úkolem je najít *Merlin* v *Montburnu*.");
            System.out.println("🔎 Použij příkaz *move montburn* a potom *talk merlin*.");
            System.out.println("═══════════════════════════════════");

            while (true) {
                System.out.print("\nZadejte příkaz: ");
                String input = scanner.nextLine().trim().toLowerCase();
                String[] commandArgs = input.split(" ");

                if (commandArgs.length == 0) {
                    System.out.println("Zadejte příkaz!");
                    continue;
                }

                Command command = commands.get(commandArgs[0]);

                if (command != null) {
                    command.execute(commandArgs);
                } else {
                    System.out.println("Neznámý příkaz. Použijte 'help' pro seznam příkazů.");
                }
            }
        }
    }
}
