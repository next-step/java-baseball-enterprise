package study;

import static org.assertj.core.api.Assertions.assertThat;

import number_baseball.enums.GameSettings;
import number_baseball.model.GameResult;
import number_baseball.model.InputAnswer;
import number_baseball.strategy.ComputerPlayStrategy;
import number_baseball.strategy.NumberBaseBallStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    private final NumberBaseBallStrategy strategy = new ComputerPlayStrategy();

    private InputAnswer input;

    @BeforeEach
    void init() {
        input = strategy.offerNumber();
    }

    @Test
    @DisplayName("랜덤 숫자 테스트")
    void testRandomNumber() {
        assertThat(input.getNumber().length())
                .isEqualTo(GameSettings.MAX_LENGTH);
    }

    @Test
    @DisplayName("중복되지 않는 숫자 테스트")
    void testUniqueness() {
        assertThat(input.getNumber().charAt(0))
                .isNotEqualTo(input.getNumber().charAt(1));
        assertThat(input.getNumber().charAt(0))
                .isNotEqualTo(input.getNumber().charAt(2));
        assertThat(input.getNumber().charAt(1))
                .isNotEqualTo(input.getNumber().charAt(2));
    }

    @Test
    @DisplayName("게임 결과 테스트: 3-strike")
    void test3StrikeResult() {
        GameResult result = strategy.verifyAnswer("123", "123");
        assertThat(result.getStrike())
                .isEqualTo(3);
        assertThat(result.getBall())
                .isEqualTo(0);
        assertThat(result.isFinished())
                .isEqualTo(true);
    }

    @Test
    @DisplayName("게임 결과 테스트: 2-strike")
    void test2StrikeResult() {
        GameResult result = strategy.verifyAnswer("972", "976");
        assertThat(result.getStrike())
                .isEqualTo(2);
        assertThat(result.getBall())
                .isEqualTo(0);
        assertThat(result.isFinished())
                .isEqualTo(false);
    }

    @Test
    @DisplayName("게임 결과 테스트: 1-strike")
    void test1StrikeResult() {
        GameResult result = strategy.verifyAnswer("246", "156");
        assertThat(result.getStrike())
                .isEqualTo(1);
        assertThat(result.getBall())
                .isEqualTo(0);
        assertThat(result.isFinished())
                .isEqualTo(false);
    }

    @Test
    @DisplayName("게임 결과 테스트: 1-strike 1-ball")
    void test1Strike1BallResult() {
        GameResult result = strategy.verifyAnswer("893", "392");
        assertThat(result.getStrike())
                .isEqualTo(1);
        assertThat(result.getBall())
                .isEqualTo(1);
        assertThat(result.isFinished())
                .isEqualTo(false);
    }

    @Test
    @DisplayName("게임 결과 테스트: 1-strike 2-ball")
    void test1Strike2BallResult() {
        GameResult result = strategy.verifyAnswer("238", "832");
        assertThat(result.getStrike())
                .isEqualTo(1);
        assertThat(result.getBall())
                .isEqualTo(2);
        assertThat(result.isFinished())
                .isEqualTo(false);
    }

    @Test
    @DisplayName("게임 결과 테스트: nothing")
    void testNothingResult() {
        GameResult result = strategy.verifyAnswer("196", "287");
        assertThat(result.getStrike())
                .isEqualTo(0);
        assertThat(result.getBall())
                .isEqualTo(0);
        assertThat(result.isFinished())
                .isEqualTo(false);
    }
}
