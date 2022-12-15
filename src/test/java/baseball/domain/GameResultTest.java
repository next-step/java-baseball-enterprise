package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameResultTest {

    @ParameterizedTest
    @MethodSource
    void getStrike(List<Integer> player, List<Integer> computer, int expectedStrikeCount) {
        assertThat(GameResult.getStrike(player, computer).value)
                .isEqualTo(expectedStrikeCount);
    }

    private static Stream<Arguments> getStrike() {
        return Stream.of(
                arguments(List.of(1, 2, 3), List.of(4, 5, 6), 0),
                arguments(List.of(1, 2, 3), List.of(2, 3, 1), 0),
                arguments(List.of(1, 2, 8), List.of(4, 2, 3), 1),
                arguments(List.of(1, 2, 3), List.of(9, 1, 3), 1),
                arguments(List.of(1, 2, 3), List.of(4, 2, 3), 2),
                arguments(List.of(1, 2, 3), List.of(1, 2, 3), 3)
        );
    }

    @ParameterizedTest
    @MethodSource
    void getBall(List<Integer> player, List<Integer> computer, int expectedBallCount) {
        assertThat(GameResult.getBall(player, computer).value)
                .isEqualTo(expectedBallCount);
    }

    private static Stream<Arguments> getBall() {
        return Stream.of(
                arguments(List.of(1, 2, 3), List.of(4, 5, 6), 0),
                arguments(List.of(1, 2, 8), List.of(4, 2, 3), 0),
                arguments(List.of(1, 2, 3), List.of(4, 2, 3), 0),
                arguments(List.of(1, 2, 3), List.of(2, 4, 3), 1),
                arguments(List.of(1, 2, 3), List.of(9, 1, 3), 1),
                arguments(List.of(1, 2, 3), List.of(2, 3, 1), 3)
        );
    }

    @Test
    void isGameContinue() {
        GameResult gameResult = new GameResult(3, 0);
        assertThat(gameResult.isGameContinue(3)).isFalse();
    }
}