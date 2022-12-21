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
        assertEquals(baseBallGame.chosen, 0);
        assertEquals(baseBallGame.restart,false);
        assertArrayEquals(baseBallGame.numbers, new int[BaseBallGame.DIGIT_SIZE]);
    }

//    @Test
//    void setNumbers() {
//    }

//    @Test
//    void getRandomNumber() {
//        int result = baseBallGame.getRandomNumber();
//        assertTrue(result>= BaseBallGame.RANGE_LOW);
//        assertTrue(result<= BaseBallGame.RANGE_HIGH);
//        for (int number: baseBallGame.numbers) {
//            assertNotEquals(result, number);
//        }
//    }

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