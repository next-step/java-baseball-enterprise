package game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UnitTest {
    @Test
    void gameRule_can_judgeResult() {
        GameRule gameRule = new GameRule();
        int[] numbersTarget = {1,2,3};
        int[] numbersTestCase;
        GameRule.Result result;

        // 3 strike
        numbersTestCase = new int[]{1,2,3};
        result = gameRule.judgeResult(numbersTarget, numbersTestCase);
        assertEquals(3, result.strike);
        assertEquals(0, result.ball);
        assertTrue(result.isEnd);

        // 2 strike
        numbersTestCase = new int[]{1,2,4};
        result = gameRule.judgeResult(numbersTarget, numbersTestCase);
        assertEquals(2, result.strike);
        assertEquals(0, result.ball);
        assertFalse(result.isEnd);

        // 1 strike 2 ball
        numbersTestCase = new int[]{1,3,2};
        result = gameRule.judgeResult(numbersTarget, numbersTestCase);
        assertEquals(1, result.strike);
        assertEquals(2, result.ball);
        assertFalse(result.isEnd);

        // 1 strike 1 ball
        numbersTestCase = new int[]{1,3,4};
        result = gameRule.judgeResult(numbersTarget, numbersTestCase);
        assertEquals(1, result.strike);
        assertEquals(1, result.ball);
        assertFalse(result.isEnd);

        // 1 strike
        numbersTestCase = new int[]{1,4,5};
        result = gameRule.judgeResult(numbersTarget, numbersTestCase);
        assertEquals(1, result.strike);
        assertEquals(0, result.ball);
        assertFalse(result.isEnd);

        // 3 ball
        numbersTestCase = new int[]{2,3,1};
        result = gameRule.judgeResult(numbersTarget, numbersTestCase);
        assertEquals(0, result.strike);
        assertEquals(3, result.ball);
        assertFalse(result.isEnd);

        // 2 ball
        numbersTestCase = new int[]{2,1,4};
        result = gameRule.judgeResult(numbersTarget, numbersTestCase);
        assertEquals(0, result.strike);
        assertEquals(2, result.ball);
        assertFalse(result.isEnd);

        // 1 ball
        numbersTestCase = new int[]{2,4,5};
        result = gameRule.judgeResult(numbersTarget, numbersTestCase);
        assertEquals(0, result.strike);
        assertEquals(1, result.ball);
        assertFalse(result.isEnd);

        // nothing
        numbersTestCase = new int[]{4,5,6};
        result = gameRule.judgeResult(numbersTarget, numbersTestCase);
        assertEquals(0, result.strike);
        assertEquals(0, result.ball);
        assertFalse(result.isEnd);
    }
}
