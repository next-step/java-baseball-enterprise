package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PitcherTest {
    Pitcher pitcher;

    @BeforeEach
    void setUp() {
        pitcher = new Pitcher();
    }

    @Test
    @DisplayName("랜덤 세자리 숫자 생성 확인")
    void lengthTest() {
        String number = pitcher.generateNumber();
        assertThat(3).isEqualTo(number.length());
    }
}
