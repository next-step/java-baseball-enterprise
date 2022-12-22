package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RefereeTest {
    Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @Test
    @DisplayName("스트라이크 볼 판단 확인")
    void judgeTest() {
        assertThat(new int[] {2, 0}).isEqualTo(referee.judge("123", "125"));
    }
}
