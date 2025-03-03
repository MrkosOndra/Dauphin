public class Take extends Command{
    public Take(WorldMap map) {
        super(map);
    }

    @Override
    public void execute(String[] args) {

    }

    @Override
    public boolean exit() {
        return false;
    }
}
