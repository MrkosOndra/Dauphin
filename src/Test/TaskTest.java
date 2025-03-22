package Test;
import World.Task;
import Game.Player;
import World.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    void testTaskCompletion() {
        Player player = new Player();
        Item needed = new Item("Golden Key");
        player.addItem(needed);
        Task task = new Task("Unlock the gate", needed, new Item("Reward"), 500000);
        assertTrue(task.checkCompletion(player));
    }

    @Test
    void testTaskReward() {
        Task task = new Task("Something", new Item("Need"), new Item("Prize"), 1000);
        assertEquals("Prize", task.getReward().getName());
    }
}
