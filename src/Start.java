import java.util.Scanner;

public class Start {
    private WorldMap world;
    private Move move;
    private Exit exit;
    private Scanner scanner;

    public Start() {
        this.scanner = new Scanner(System.in);
        this.world = new WorldMap();
    }

    public void run() {
        if (world.loadMap()) {
            world.printMap();

            this.move = new Move(world);
            this.exit= new Exit(world);

            System.out.println("Vítejte ve hře! Použijte příkaz 'move <místo>' pro pohyb nebo 'exit' pro ukončení.");

            while (true) {
                world.setStartLocation("Orleans");
                System.out.print("\nZadejte příkaz: ");
                String input = scanner.nextLine().trim().toLowerCase();
                String[] commandArgs = input.split(" ");

                if (commandArgs[0].equals("move")) {
                    move.execute(commandArgs);
                } else if (commandArgs[0].equals("exit")) {
                   exit.execute(commandArgs);
                } else {
                    System.out.println("Neznámý příkaz. Použijte 'move <místo>' nebo 'exit'.");
                }
            }
        }
    }
}
