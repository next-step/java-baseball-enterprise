import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

class NumberBaseballTest {

    NumberBaseball numberBaseball = new NumberBaseball();
    static int input = 935;
    @BeforeAll
    static void setAnswer(){
        NumberBaseball.setAnswer();
        NumberBaseball.setGuess(input);
    }

    @Test
    @DisplayName("각 자리의 숫자가 서로 다른지 확인")
    void setAnswer_ShouldEachAnswerDigitsAreDifferent(){
        int[] answer = NumberBaseball.answer;

        assertThat(answer[0]).isNotEqualTo(answer[1]);
        assertThat(answer[1]).isNotEqualTo(answer[2]);
        assertThat(answer[2]).isNotEqualTo(answer[0]);
    }

    @Test
    @DisplayName("input을 정상적으로 slicing 하는지 확인")
    void getGuess_ShouldGenerateTheExpectedGuess() {

        int[] actual = NumberBaseball.guess;
        int[] expected = new int[]{9, 3, 5};

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("guess의 특정 digit가 올바른 볼카운트를 생성하는지 확인")
    void checkSingleDigit_ShouldGenerateTheExpectedCount() {
        int[] answerExample = new int[] {9, 2, 3};

        assertThat(NumberBaseball.checkSingleDigit(answerExample, 0)).isEqualTo(10);
        assertThat(NumberBaseball.checkSingleDigit(answerExample, 1)).isEqualTo(1);
        assertThat(NumberBaseball.checkSingleDigit(answerExample, 2)).isEqualTo(0);
    }
}