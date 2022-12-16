package baseball;

import baseball.validator.InputRestartValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputRestartValidatorTest {
    private static final String INVALID_RESTART_INPUT_ERROR_MESSAGE = "[ERROR] 입력을 확인해주세요.";

    @DisplayName("재시작 입력이 '1' + 공백인 경우 true, '2'인 경우 false를 return한다.")
    @Test
    void InputRestart_성공테스트() {
        assertThat(InputRestartValidator.validate("1")).isEqualTo(true);
        assertThat(InputRestartValidator.validate("1 ")).isEqualTo(true);
        assertThat(InputRestartValidator.validate("   1        ")).isEqualTo(true);
        assertThat(InputRestartValidator.validate("2")).isEqualTo(false);
    }

    @DisplayName("재시작 입력이 1, 2가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"a", "09", "c", "d"})
    @ParameterizedTest
    void InputRestart_실패테스트(String inputString) {
        assertThatThrownBy(() -> InputRestartValidator.validate(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RESTART_INPUT_ERROR_MESSAGE);
    }
}

