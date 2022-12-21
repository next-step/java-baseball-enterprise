package baseball;

import baseball.dto.GuessResult;
import baseball.model.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    @DisplayName("채점 테스트")
    @ParameterizedTest(name = "{index}) target:{0}, answer:{1}, expected:{2}")
    @MethodSource("provider")
    void check(int target, int answer, GuessResult expected) {
        Game game = getGame(target);
        GuessResult result = game.check(answer);
        assertThat(result.getStrike()).isEqualTo(expected.getStrike());
        assertThat(result.getBall()).isEqualTo(expected.getBall());
    }

    private Game getGame(int target) {
        int x = target / 100;
        int y = target / 10 % 10;
        int z = target % 10;
        return new Game(new int[]{x, y, z});
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(123, 456, new GuessResult(0, 0)),
                Arguments.of(478, 485, new GuessResult(1, 1)),
                Arguments.of(481, 481, new GuessResult(3, 0)),
                Arguments.of(528, 852, new GuessResult(0, 3)),
                Arguments.of(842, 847, new GuessResult(2, 0))
        );
    }
}
