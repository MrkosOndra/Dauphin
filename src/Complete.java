public class Complete extends Command{
    public Complete(WorldMap map) {
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
