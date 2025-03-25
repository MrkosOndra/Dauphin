package Command;
import World.Location;
import World.WorldMap;
import World.WorldMap.*;
/**
 * Abstraktní třída pro herní příkaz (Command).
 * Všechny konkrétní příkazy (Move, Talk, Exit...) z ní dědí.
 * @author Ondra
 */
public abstract class Command {
    protected WorldMap map;
    protected Location currentLocation;

    public Command(WorldMap map) {
        this.map = map;
    }
    /**
     * Spustí daný příkaz.
     * @param args vstupní parametry příkazu
     */
    public abstract void execute(String[] args);
    /**
     * Zda má příkaz ukončit hru.
     * @return true pokud končí hru
     */
    public abstract boolean exit();
}
