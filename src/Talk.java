public class Talk extends Command{
    public Talk(WorldMap map) {
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
