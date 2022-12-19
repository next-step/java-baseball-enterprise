import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {

    @Test
    void isThreeStrike() {
        Answer answer = Answer.forTestCode(1, 2, 3);
        ScoreBoard scoreBoard = ScoreBoard.forTestCode(answer, 3, 0, 0);
        assertTrue(scoreBoard.isThreeStrike());
    }

    @Test
    void isTreeStrike_fail() {
        Answer answer = Answer.forTestCode(1, 2, 3);
        ScoreBoard scoreBoard = ScoreBoard.forTestCode(answer, 2, 1, 0);
        assertFalse(scoreBoard.isThreeStrike());
    }

    @Test
    void reset() {
        Answer answer = Answer.forTestCode(1, 2, 3);
        ScoreBoard scoreBoard = ScoreBoard.forTestCode(answer, 3, 0, 0);
        scoreBoard.reset();

        assertNotEquals(answer, scoreBoard.getAnswer());

        assertEquals(0, scoreBoard.getStrike());
        assertEquals(0, scoreBoard.getBall());
        assertEquals(0, scoreBoard.getNothing());
    }

    @Test
    void checkScore() {
        Answer answer = Answer.forTestCode(1, 2, 3);
        ScoreBoard scoreBoard = ScoreBoard.forTestCode(answer, 0, 0 ,0);

        HashMap<Integer, Integer> userInput1 = new HashMap<>();
        HashMap<Integer, Integer> userInput2 = new HashMap<>();
        HashMap<Integer, Integer> userInput3 = new HashMap<>();

        userInput1.put(1, 0);
        userInput1.put(2, 1);
        userInput1.put(3, 2);

        scoreBoard.checkScore(userInput1);
        assertEquals(3, scoreBoard.getStrike());
        assertEquals(0, scoreBoard.getBall());
        assertEquals(0, scoreBoard.getNothing());

        userInput2.put(3, 0);
        userInput2.put(2, 1);
        userInput2.put(1, 2);

        scoreBoard.checkScore(userInput2);
        assertEquals(1, scoreBoard.getStrike());
        assertEquals(2, scoreBoard.getBall());
        assertEquals(0, scoreBoard.getNothing());

        userInput3.put(4, 0);
        userInput3.put(5, 1);
        userInput3.put(6, 2);

        scoreBoard.checkScore(userInput3);
        assertEquals(0, scoreBoard.getStrike());
        assertEquals(0, scoreBoard.getBall());
        assertEquals(3, scoreBoard.getNothing());
    }
}