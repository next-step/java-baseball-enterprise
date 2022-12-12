package study;

import org.assertj.core.api.Assertions;
import org.assertj.core.error.ShouldBeFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class BaseballGameTest {
    private final String answer;
    private BaseballGame bg;
    private final int DIGITS = 3;

    public BaseballGameTest() throws NoSuchFieldException, IllegalAccessException {
        bg = new BaseballGame();
        Field answerField = bg.getClass().getDeclaredField("answer");
        answerField.setAccessible(true);
        answer = String.valueOf(answerField.get(bg));
        System.out.println("answer = " + answer);
    }
    @RepeatedTest(100)
    @DisplayName("정답생성: 숫자가 3자리로 이루어져있는가??")
    void numberGenerateTest1() {
        Assertions.assertThat(answer.length()).isEqualTo(DIGITS);
    }

    @RepeatedTest(100)
    @DisplayName("정답생성: 숫자로만 이루어져있는가?")
    void numberGenerateTest2() {
        boolean flag = true;
        for(int i =0; i<DIGITS; i++) {
            if (answer.charAt(i) > '9' || answer.charAt(i) < '0') {
                flag = false;
                break;
            }
        }
        Assertions.assertThat(flag).isTrue();
    }

    @RepeatedTest(100)
    @DisplayName("정답생성: 중복되는 숫자가 없는가?")
    void numberGenerateTest3() {
        Set<Integer> hashSet = new HashSet<Integer>();
        for(int i =0; i<DIGITS; i++) {
            int number = Character.getNumericValue(answer.charAt(i));
            hashSet.add(number);
        }
        Assertions.assertThat(hashSet.size()).isEqualTo(DIGITS);
    }

    @RepeatedTest(100)
    @DisplayName("정답생성: 0이 포함돼있지 않는가?")
    void numberGenerateTest4() {
        Assertions.assertThat(answer.contains("0")).isFalse();
    }
}
