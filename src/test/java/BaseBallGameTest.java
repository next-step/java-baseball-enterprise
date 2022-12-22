import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameTest {
    static BaseBallGame baseBallGame;

    @BeforeEach
    public void BeforeEach(){
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

    @Test
    void setNumbers() {
        baseBallGame.initGame();
        baseBallGame.setNumbers();
        assertEquals(baseBallGame.chosen.size(), BaseBallGame.DIGIT_SIZE);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < BaseBallGame.DIGIT_SIZE; i++) {
            int number = baseBallGame.chosen.get(i);
            assertTrue(number>= BaseBallGame.RANGE_LOW);
            assertTrue(number<= BaseBallGame.RANGE_HIGH);
            set.add(number);
        }
        assertEquals(set.size(), BaseBallGame.DIGIT_SIZE);
    }

    @Test
    void getRandomNumber() {
        baseBallGame.initGame();
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