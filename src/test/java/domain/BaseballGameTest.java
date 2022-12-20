package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    @DisplayName("사용자의 수와 컴퓨터의 수 비교 테스트")
    @ParameterizedTest
    @MethodSource("provideComputerNumbersAndUserNumbers")
    void compareNumbersTest(String computerNumbers, String userNumbers, String description, int strikeCount, int ballCount) {
        BaseballGame baseballGame = new BaseballGame(computerNumbers);
        GameResult gameResult = baseballGame.compareNumbers(userNumbers);

        assertThat(gameResult.getDescription()).isEqualTo(description);
        assertThat(gameResult.getStrikeCount()).isEqualTo(strikeCount);
        assertThat(gameResult.getBallCount()).isEqualTo(ballCount);
    }

    private static Stream<Arguments> provideComputerNumbersAndUserNumbers() {
        return Stream.of(
                Arguments.of("713", "123", "1스트라이크 1볼", 1, 1),
                Arguments.of("713", "145", "1볼", 0, 1),
                Arguments.of("713", "256", "낫싱", 0, 0),
                Arguments.of("713", "671", "2볼", 0, 2),
                Arguments.of("713", "713", "3스트라이크 ", 3, 0)
        );
    }

}