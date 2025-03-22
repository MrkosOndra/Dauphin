package Test;
import World.Location;
import World.WorldMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class WorldMapTest {
    @Test
    void testAddAndGetLocation() {
        WorldMap map = new WorldMap();
        Location testLoc = new Location("test");
        map.setCurrentLocation(testLoc);
        assertEquals("test", map.getCurrentLocation().getName());
    }
}
