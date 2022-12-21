import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameTest {
    static BaseBallGame baseBallGame;

    @BeforeAll
    public static void beforeAll(){
        baseBallGame = new BaseBallGame();
    }

    @Test
    void initGame() {
        baseBallGame.initGame();
        int range = BaseBallGame.RANGE_HIGH-BaseBallGame.RANGE_LOW+1;
        assertEquals(baseBallGame.chosen.size(), 0);
        assertEquals(baseBallGame.numbers.size(), range);
        for (int i = BaseBallGame.RANGE_LOW; i <= BaseBallGame.RANGE_HIGH; i++) {
            assertEquals(baseBallGame.numbers.get(i-BaseBallGame.RANGE_LOW), i);
        }
    }

//    @Test
//    void setNumbers() {
//    }

    @Test
    void getRandomNumber() {
        for (int i = BaseBallGame.RANGE_LOW; i <= BaseBallGame.RANGE_HIGH; i++) {
            int result = baseBallGame.getRandomNumber();
            assertTrue(result>= BaseBallGame.RANGE_LOW);
            assertTrue(result<= BaseBallGame.RANGE_HIGH);
        }
        assertEquals(baseBallGame.numbers.size(), 0);
    }

//    @Test
//    void getInputs() {
//    }
//
//    @Test
//    void compareNumbers() {
//    }
//
//    @Test
//    void compareDigit() {
//    }
//
//    @Test
//    void endgame() {
//    }
//
//    @Test
//    void mainGame() {
//    }
}