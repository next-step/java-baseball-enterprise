package baseball;

import baseball.domain.BaseballNumbers;
import baseball.validator.InputUserAnswerValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputUserAnswerValidatorTest {
    private static final String REGEX_ERROR_MESSAGE = "[ERROR] 형식에 맞게 입력하세요 : 중복이 없는 1과 9 사이의 3자리 수";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복이 없어야 합니다.";
    @DisplayName("inputUserAnswer가 1~9로 이루어진 세 자리의 수인 경우 BaseballNumbers를 정상적으로 반환한다.")
    @Test
    void InputRestart_성공테스트() {
        assertThat(InputUserAnswerValidator.validate("123"))
                .isEqualTo(new BaseballNumbers(new String[] {"1","2","3"}));
        assertThat(InputUserAnswerValidator.validate("1 2       3   "))
                .isEqualTo(new BaseballNumbers(new String[] {"1","2","3"}));
        assertThat(InputUserAnswerValidator.validate("     7    89"))
                .isEqualTo(new BaseballNumbers(new String[] {"7","8","9"}));
    }

    @DisplayName("inputUserAnswer가 1~9로 이루어진 세 자리의 수가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"aab", "세자리", "1234", "53129", "-1", "dㅁㅇㅎ", "100"})
    @ParameterizedTest
    void InputUserAnswer_형식_실패테스트(String inputString) {
        assertThatThrownBy(() -> InputUserAnswerValidator.validate(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(REGEX_ERROR_MESSAGE);
    }

    @DisplayName("inputUserAnswer가 1~9로 이루어진 세 자리의 수지만 중복이 있는 경우 예외가 발생한다.")
    @ValueSource(strings = {"113", "121", "122", "111", "1  13", "1 2 1", "   1 2  2   "})
    @ParameterizedTest
    void InputUserAnswer_중복_실패테스트(String inputString) {
        assertThatThrownBy(() -> InputUserAnswerValidator.validate(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_ERROR_MESSAGE);
    }
}

