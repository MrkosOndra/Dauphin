package Test;
import World.Item;
import Game.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PlayerTest {
    @Test
    void testAddItemToInventory() {
        Player player = new Player();
        Item item = new Item("Magic Stone");
        player.addItem(item);
        assertTrue(player.hasItem("Magic Stone"));
    }

    @Test
    void testWinGame() {
        Player player = new Player();
        player.winGame();
        assertTrue(player.hasWon());
    }
    @Test
    public void testHasItem() {
        Player player = new Player();
        Item sword = new Item("Excalibur");

        player.addItem(sword);

        assertTrue(player.hasItem("Excalibur"));
        assertFalse(player.hasItem("NonexistentItem"));
    }
}

