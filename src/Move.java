import java.util.Arrays;

public class Move extends Command{
    private java.util.Arrays Arrays;

    public Move(WorldMap map) {
        super(map);
    }

    @Override
    public void execute(String[] args) {
        if(args.length < 2) {
            System.out.println("Použití: move <místo>");
            return;
        }

        String destination = String.join(" ", Arrays.copyOfRange(args, 1, args.length)).toLowerCase().trim();

        Location currentLocation= map.getCurrentLocation();
        if (currentLocation == null) {
            System.out.println("Chyba: Startovní lokace není nastavena! Zkontroluj World.txt.");
            return;
        }

        System.out.println("Dostupné lokace z " + currentLocation.getName() + ": " + currentLocation.getConnections().keySet());
        System.out.println("Hledám lokaci: " + destination);

            Location nextLocation = currentLocation.getConnections().get(destination);

            if (nextLocation != null) {
                map.setCurrentLocation(nextLocation);
                currentLocation = nextLocation;
                System.out.println("Přesunul si se do: " + currentLocation.getName());
            } else {
                System.out.println("Tudy cesta nevede");
            }


    }

    @Override
    public boolean exit() {
        return false;
    }
}
