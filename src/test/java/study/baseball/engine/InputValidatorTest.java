package study.baseball.engine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.regex.Pattern;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    Pattern regex = Pattern.compile("[0-9]{3}");
    private final InputValidator validator = new InputValidator(regex);

    @ParameterizedTest
    @ValueSource(strings = {"123", "076", "234", "543", "932"})
    public void testValidInput(String input) {
        assertThat(validator.checkValidFormat(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"321312", "", "   ", "dsfjasdflk", "fdf  dfd !@#!@ d"})
    public void testInvalidFormatInput(String input) {
        assertThatThrownBy(() -> {
            validator.checkValidFormat(input);
        }).isInstanceOf(RuntimeException.class).hasMessage("입력의 형식이 잘못되었습니다.");
    }
}