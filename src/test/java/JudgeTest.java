import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class JudgeTest {
    BaseballGame game;

    JudgeTest() {
        game = new BaseballGame();
        game.setSpecificNumber("836");
    }

    @Test
    @DisplayName("Test: 1 Strike")
    void oneStrikeTest() {
        Result result = game.getResult("132");
        assertThat(result.strike == 1 && result.ball == 0)
                .isTrue();
    }

    @Test
    @DisplayName("Test: 1 Ball")
    void oneBallTest() {
        Result result = game.getResult("123");
        assertThat(result.strike == 0 && result.ball == 1)
                .isTrue();
    }

    @Test
    @DisplayName("Test: 1 Strike 1 Ball")
    void oneStrikeOneBallTest() {
        Result result = game.getResult("823");
        assertThat(result.strike == 1 && result.ball == 1)
                .isTrue();
    }

    @Test
    @DisplayName("Test: Nothing")
    void nothingTest() {
        Result result = game.getResult("124");
        assertThat(result.isNothing())
                .isTrue();
    }

    @Test
    @DisplayName("Test: Correct answer")
    void correctTest() {
        Result result = game.getResult("836");
        assertThat(result.isCorrect())
                .isTrue();
    }
}
