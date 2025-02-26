public abstract class Command {
    protected WorldMap map;
    protected Location currentLocation;

    public Command(WorldMap map, Location currentLocation) {
        this.map = map;
        this.currentLocation = map.getStartingLocation();
    }
    public abstract void execute(String[] args);
}
