package baseball;

import static baseball.Referee.judge;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JudgeTest {

    @DisplayName("포볼로 판결한다.")
    @Test
    void judgeFourBall() {
        assertThat(judge("123", "456")).isEqualTo(Judgement.FOUR_BALL);
    }

    @DisplayName("1스트라이크로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 145", "123, 425", "123, 453"})
    void judgeStrike(String rightNumbers, String inputNumbers) {
        assertThat(judge(rightNumbers, inputNumbers)).isEqualTo(Judgement.STRIKE);
    }
}
