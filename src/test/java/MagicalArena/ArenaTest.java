package MagicalArena;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {

    @Test
    public void testPlayerInitialization() {
        Player player = new Player(50, 5, 10);
        assertEquals(50, player.getHealth());
        assertEquals(5, player.getStrength());
        assertEquals(10, player.getAttack());
    }
}