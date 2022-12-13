import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class AnswerTest {

    @Test
    void initAnswer() {
        Answer answer = new Answer();

        // answerList에는 3개의 항목이 포함된다
        ArrayList<Integer> answerList = answer.getAnswerList();
        assertEquals(3, answerList.size());

        // answerList에는 중복된 항목이 없다
        boolean duplicationFlag = false;
        for (int i = 0; i < answerList.size(); i++) {
            for (int j = i+1; j < answerList.size(); j++) {
                if (answerList.get(i) == answerList.get(j)) duplicationFlag = true;
            }
        }
        assertFalse(duplicationFlag);

        // answerList에는 0이 포함되지 않는다
        boolean zeroFlag = false;
        for (Integer i : answerList) {
            if (i == 0) zeroFlag = true;
        }
        assertFalse(zeroFlag);
    }

    // 사실상 위 테스트와 동일함. 의미가 있는지 의문.
    @Test
    void resetAnswer() {
        Answer answer = new Answer();

        answer.resetAnswer();

        // answerList에는 3개의 항목이 포함된다
        ArrayList<Integer> answerList = answer.getAnswerList();
        assertEquals(3, answerList.size());

        // answerList에는 중복된 항목이 없다
        boolean duplicationFlag = false;
        for (int i = 0; i < answerList.size(); i++) {
            for (int j = i+1; j < answerList.size(); j++) {
                if (answerList.get(i) == answerList.get(j)) duplicationFlag = true;
            }
        }
        assertFalse(duplicationFlag);

        // answerList에는 0이 포함되지 않는다
        boolean zeroFlag = false;
        for (Integer i : answerList) {
            if (i == 0) zeroFlag = true;
        }
        assertFalse(zeroFlag);
    }
}
