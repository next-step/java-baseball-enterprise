package gametest;

import game.GameInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameInputValidatorTest {
    private final GameInputValidator gameInputValidator = new GameInputValidator();

    @DisplayName("[GameInputValidator] 게임 인풋 유효성 테스트")
    @ParameterizedTest
    @MethodSource("validateGameInputTestGenerator")
    void validateGameInputTest(String input, boolean expected){
        boolean result = gameInputValidator.validateGameInput(input);

        assertThat(result).isEqualTo(expected);
    }
    private static Stream<Arguments> validateGameInputTestGenerator(){
        return Stream.of(
                Arguments.of("123", true),
                Arguments.of("253", true),
                Arguments.of("12", false),
                Arguments.of("1829", false),
                Arguments.of("12a", false),
                Arguments.of("12 a", false)
        );
    }

    @DisplayName("[GameInputValidator] 재시작 입력값 유효성 테스트")
    @ParameterizedTest
    @MethodSource("validateRestartInputTestGenerator")
    void validateRestartInputTest(String input, boolean expected){
        boolean result = gameInputValidator.validateRestartInput(input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> validateRestartInputTestGenerator(){
        return Stream.of(
                Arguments.of("1", true),
                Arguments.of("2", true),
                Arguments.of("3", false),
                Arguments.of("0", false),
                Arguments.of("", false),
                Arguments.of("123", false),
                Arguments.of("a", false),
                Arguments.of("7h", false)
        );
    }

}
