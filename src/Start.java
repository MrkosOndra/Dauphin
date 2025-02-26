import java.util.Scanner;

public class Start {
    private WorldMap world;
    private Move moveCommand;
    private Scanner scanner;

    public Start() {
        this.world = new WorldMap();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        if (world.loadMap()) {
            world.printMap();

            this.moveCommand = new Move(world);

            System.out.println("Vítejte ve hře! Použijte příkaz 'move <místo>' pro pohyb nebo 'exit' pro ukončení.");

            while (true) {
                System.out.print("\nZadejte příkaz: ");
                String input = scanner.nextLine().trim().toLowerCase();
                String[] commandArgs = input.split(" ");

                if (commandArgs[0].equals("move")) {
                    moveCommand.execute(commandArgs);
                } else if (commandArgs[0].equals("exit")) {
                    System.out.println("Hra ukončena.");
                    break;
                } else {
                    System.out.println("Neznámý příkaz. Použijte 'move <místo>' nebo 'exit'.");
                }
            }
        }
    }
}
