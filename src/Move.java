public class Move extends Command{
    public Move(WorldMap map) {
        super(map);
    }

    @Override
    public void execute(String[] args) {
        if(args.length>2) {
            System.out.println("Použití: move <místo>");
            return;
        }

            String destination = args[1].toLowerCase();
            Location nextLocation = currentLocation.getConnections().get(destination);

            if (nextLocation != null) {
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
