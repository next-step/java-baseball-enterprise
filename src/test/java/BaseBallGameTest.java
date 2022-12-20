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
        assertEquals(baseBallGame.restart,false);
        assertArrayEquals(baseBallGame.numbers, new int[BaseBallGame.DIGIT_SIZE]);
    }

//    @Test
//    void setNumbers() {
//    }
//
//    @Test
//    void getRandomNumber() {
//    }
//
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