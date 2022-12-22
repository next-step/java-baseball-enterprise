package baseball;

import baseball.domain.computer.Computer;
import baseball.domain.user.UserInput;
import baseball.domain.computer.RandomNumbers;
import baseball.util.util.NumberUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class BaseballTest {
    @ParameterizedTest
    @CsvSource(value = {"123:123:3 스트라이크", "347:357:2 스트라이크", "487:137:1 스트라이크"}, delimiter = ':')
    @DisplayName("스트라이크 확인")
    public void strike(String answer, String input, String result) {
        validateResult(answer, input, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"312:123:3볼", "731:357:2볼", "483:137:1볼"}, delimiter = ':')
    @DisplayName("볼 확인")
    public void ball(String answer, String input, String result) {
        validateResult(answer, input, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"139:123:1 스트라이크 1볼", "512:531:1 스트라이크 1볼"}, delimiter = ':')
    @DisplayName("스트라이크 + 볼 확인")
    public void strikeAndBall(String answer, String input, String result) {
        validateResult(answer, input, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"413:679:낫싱", "512:346:낫싱"}, delimiter = ':')
    @DisplayName("낫싱 확인")
    public void nothing(String answer, String input, String result) {
        validateResult(answer, input, result);
    }

    private void validateResult(String answer, String input, String expected) {
        Computer computer = new Computer(new RandomNumbers(NumberUtils.getSingleIntegerListFromInt(Integer.parseInt(answer))));
        Assertions.assertThat(computer.calculateResult(new UserInput(input))
                .exportResultString())
                .isEqualTo(expected);
    }
}
