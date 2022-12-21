package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JudgeResultTest {

    @Test
    @DisplayName("to_string_낫싱_test")
    void toStringNothingTest() {
        JudgeResult judgeResult = new JudgeResult(0, 0);
        assertThat(judgeResult.toString()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("to_string_3strike_test")
    void toStringThreeStrikeTest() {
        JudgeResult judgeResult = new JudgeResult(3, 0);
        assertThat(judgeResult.toString()).isEqualTo("3 스트라이크");
    }

    @Test
    @DisplayName("to_string_3ball_test")
    void toStringThreeBallTest() {
        JudgeResult judgeResult = new JudgeResult(0, 3);
        assertThat(judgeResult.toString()).isEqualTo("3 볼");
    }

    @Test
    @DisplayName("to_string_1strike_1ball_test")
    void toStringOneStrikeOneBallTest() {
        JudgeResult judgeResult = new JudgeResult(1, 1);
        assertThat(judgeResult.toString()).isEqualTo("1 스트라이크 1 볼");
    }
}