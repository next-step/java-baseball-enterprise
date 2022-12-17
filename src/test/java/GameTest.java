import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void askRestart() {
        //given
        Game game = new Game();
        //when
        boolean b1 = game.askRestart(1);
        boolean b2 = game.askRestart(2);
        //then
        assertTrue(b1);
        assertFalse(b2);
    }
}