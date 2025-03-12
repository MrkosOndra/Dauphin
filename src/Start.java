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
    }

    public void run() {
        if (world.loadMap()) {
            world.printMap();
            world.setStartLocation("Orleans");
            System.out.println("Vítejte ve hře!");

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
