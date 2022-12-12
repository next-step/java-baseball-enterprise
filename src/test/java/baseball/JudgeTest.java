package baseball;

import static baseball.Referee.judge;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JudgeTest {

    @DisplayName("낫싱로 판결한다.")
    @Test
    void judgeNothing() {
        assertThat(judge("123", "456")).isEqualTo(new Judgement(0, 0));
    }

    @DisplayName("1스트라이크로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 145", "123, 425", "123, 453"})
    void judgeOneStrike(String rightNumbers, String inputNumbers) {
        assertThat(judge(rightNumbers, inputNumbers)).isEqualTo(new Judgement(1, 0));
    }

    @DisplayName("2스트라이크로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 124", "456, 156", "789, 759"})
    void judgeTwoStrike(String rightNumbers, String inputNumbers) {
        assertThat(judge(rightNumbers, inputNumbers)).isEqualTo(new Judgement(2, 0));
    }

    @DisplayName("1볼을 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 415", "123, 451", "123, 245", "123, 452", "123, 345", "123, 435"})
    void judgeOneBall(String rightNumbers, String inputNumbers) {
        assertThat(judge(rightNumbers, inputNumbers)).isEqualTo(new Judgement(0, 1));
    }
}
