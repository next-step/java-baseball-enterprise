package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @DisplayName("스트라이크/볼 증가 테스트")
    @ParameterizedTest
    @MethodSource("provideIncreaseCount")
    void increaseStrikeAndBallCountTest(int strikeCount, int ballCount) {
        GameResult gameResult = new GameResult();

        for (int i = 0; i < strikeCount; i++) {
            gameResult.increaseStrikeCount();
        }

        for (int i = 0; i < ballCount; i++) {
            gameResult.increaseBallCount();
        }

        assertThat(gameResult.getStrikeCount()).isEqualTo(strikeCount);
        assertThat(gameResult.getBallCount()).isEqualTo(ballCount);
    }

    @DisplayName("스트라이크와 볼 카운트가 없는 케이스 테스트")
    @Test
    void checkIsNothingTest() {
        GameResult gameResult = new GameResult();

        assertThat(gameResult.checkIsNothing()).isEqualTo("낫싱");
        assertThat(gameResult.checkStrikeCount()).isEmpty();
        assertThat(gameResult.checkBallCount()).isEmpty();
    }

    @DisplayName("스트라이크와 볼이 있는 케이스 테스트")
    @Test
    void checkStringAndBallCount() {
        GameResult gameResult = new GameResult();
        int strikeCount = 1, ballCount = 1;

        for (int i = 0; i < strikeCount; i++) {
            gameResult.increaseStrikeCount();
        }

        for (int i = 0; i < ballCount; i++) {
            gameResult.increaseBallCount();
        }

        assertThat(gameResult.checkStrikeCount()).isEqualTo(strikeCount + "스트라이크 ");
        assertThat(gameResult.checkBallCount()).isEqualTo(ballCount + "볼");
    }


    @DisplayName("게임 결과 판별 테스트")
    @ParameterizedTest
    @MethodSource("provideCountAndDescription")
    void gameResultDescriptionTest(int strikeCount, int ballCount, String description) {
        GameResult gameResult = new GameResult();

        for (int i = 0; i < strikeCount; i++) {
            gameResult.increaseStrikeCount();
        }

        for (int i = 0; i < ballCount; i++) {
            gameResult.increaseBallCount();
        }

        assertThat(gameResult.getDescription()).isEqualTo(description);
    }

    private static Stream<Arguments> provideIncreaseCount() {
        return Stream.of(
                Arguments.of(3, 0),
                Arguments.of(1, 2),
                Arguments.of(0, 0)
        );
    }

    private static Stream<Arguments> provideCountAndDescription() {
        return Stream.of(
                Arguments.of(0, 0, "낫싱"),
                Arguments.of(2, 1, "2스트라이크 1볼"),
                Arguments.of(0, 3, "3볼")
        );
    }

}