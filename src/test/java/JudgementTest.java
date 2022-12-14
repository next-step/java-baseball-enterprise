import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest {
    private final int[] answerNumbers = new int[]{7,5,0};
    private final Judgement judgement = new Judgement();

    @Test
    @DisplayName("3 strikes")
    void threeStrikes() {
        String userInput = "750";
        JudgementResult judgementResult = judgement.judge(answerNumbers, userInput);
        assertThat(judgementResult.strikes).isEqualTo(3);
        assertThat(judgementResult.balls).isEqualTo(0);
    }

    @Test
    @DisplayName("2 strikes")
    void twoStrikes() {
        String userInput = "720";
        JudgementResult judgementResult = judgement.judge(answerNumbers, userInput);
        assertThat(judgementResult.strikes).isEqualTo(2);
        assertThat(judgementResult.balls).isEqualTo(0);
    }

    @Test
    @DisplayName("1 strike")
    void oneStrike() {
        String userInput = "953";
        JudgementResult judgementResult = judgement.judge(answerNumbers, userInput);
        assertThat(judgementResult.strikes).isEqualTo(1);
        assertThat(judgementResult.balls).isEqualTo(0);
    }

    @Test
    @DisplayName("1 strike 2 balls")
    void oneStrikeTwoBalls() {
        String userInput = "705";
        JudgementResult judgementResult = judgement.judge(answerNumbers, userInput);
        assertThat(judgementResult.strikes).isEqualTo(1);
        assertThat(judgementResult.balls).isEqualTo(2);
    }

    @Test
    @DisplayName("2 balls")
    void twoBalls() {
        String userInput = "571";
        JudgementResult judgementResult = judgement.judge(answerNumbers, userInput);
        assertThat(judgementResult.strikes).isEqualTo(0);
        assertThat(judgementResult.balls).isEqualTo(2);
    }

    @Test
    @DisplayName("3 balls")
    void threeBalls() {
        String userInput = "507";
        JudgementResult judgementResult = judgement.judge(answerNumbers, userInput);
        assertThat(judgementResult.strikes).isEqualTo(0);
        assertThat(judgementResult.balls).isEqualTo(3);
    }

    @Test
    @DisplayName("1 ball")
    void oneBall() {
        String userInput = "602";
        JudgementResult judgementResult = judgement.judge(answerNumbers, userInput);
        assertThat(judgementResult.strikes).isEqualTo(0);
        assertThat(judgementResult.balls).isEqualTo(1);
    }

    @Test
    @DisplayName("Nothing")
    void nothing() {
        String userInput = "316";
        JudgementResult judgementResult = judgement.judge(answerNumbers, userInput);
        assertThat(judgementResult.strikes).isEqualTo(0);
        assertThat(judgementResult.balls).isEqualTo(0);
    }
}
