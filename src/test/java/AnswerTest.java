import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.assertj.core.util.Arrays;
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

    // 사실상 위 테스트와 동일함. 의미가 있는지 의문.
    @Test
    void resetAnswer() {
        Answer answer = new Answer();

        answer.resetAnswer();

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
        Answer answer = new Answer();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        for (Integer answerNum : answer.getAnswerMap().keySet()) {
            // answerMap에 포함된 숫자들은 contains에서 true를 리턴한다
            assertTrue(answer.contains(answerNum));
            list.remove(answerNum);
        }

        for (Integer wrongNum : list) {
            // answerMap에 포함되지 않은 숫자들은 contains에서 false를 리턴한다
            assertFalse(answer.contains(wrongNum));
        }
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
