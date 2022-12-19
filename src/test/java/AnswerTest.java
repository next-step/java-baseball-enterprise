import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class AnswerTest {
    @Test
    void initAnswer() {
        Answer answer = new Answer();

        // answerMap에는 3개의 항목이 포함된다
        HashMap<Integer, Integer> answerMap = answer.getAnswerMap();
        assertEquals(3, answerMap.size());

        // answerMap에는 0이 포함되지 않는다
        boolean zeroFlag = false;
        if (answerMap.containsKey(0)) {
            zeroFlag = true;
        }
        assertFalse(zeroFlag);
    }

    @Test
    void contains() {
        Answer answer = Answer.forTestCode(1, 2, 3);

        assertTrue(answer.contains(1));
        assertTrue(answer.contains(2));
        assertTrue(answer.contains(3));

        assertFalse(answer.contains(4));
        assertFalse(answer.contains(5));
        assertFalse(answer.contains(6));
    }

    @Test
    void getIndex() {
        Answer answer = new Answer();
        HashMap<Integer, Integer> answerMap = answer.getAnswerMap();

        for (Integer answerNum : answerMap.keySet()) {
            // answer의 getIndex 결과값과 answerMap의 get결과값은 언제나 동일하다.
            assertEquals(answer.getIndex(answerNum), answerMap.get(answerNum));
        }
    }
}
