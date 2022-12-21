import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

class NumberBaseballTest {

    NumberBaseball numberBaseball = new NumberBaseball();

    @Test
    void setAnswer_EachAnswerNumbersAreDifferent(){
        // 각 자리의 숫자가 서로 다른지 확인
        NumberBaseball.setAnswer();
        int[] answer = NumberBaseball.answer;

        assertThat(answer[0]).isNotEqualTo(answer[1]);
        assertThat(answer[1]).isNotEqualTo(answer[2]);
        assertThat(answer[2]).isNotEqualTo(answer[0]);
    }

    @Test
    void getGuess_InputNumberIsSlicedWell() {
        // inputNumber가 정상적으로 slicing 되어 guess를 초기화하는지 확인
        int inputNumber = 935;

        NumberBaseball.setGuess(inputNumber);

        int[] actual = NumberBaseball.guess;
        int[] expected = new int[]{9, 3, 5};

        assertThat(actual).isEqualTo(expected);
    }
}