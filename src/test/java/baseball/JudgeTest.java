package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgeTest {

    @DisplayName("포볼을 판결한다.")
    @Test
    void judgeFourBall() {
        assertThat(Referee.judge("123", "456")).isEqualTo(Judgement.FOUR_BALL);
    }
}
