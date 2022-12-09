package baseball;

import org.junit.jupiter.api.Test;

import static baseball.GameService.*;
import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {

    @Test
    void constValueTest() {
        assertThat(NUMBERS_SIZE)
                .isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(9);
        assertThat(MAX_NUMBER).isGreaterThanOrEqualTo(MIN_NUMBER);
        assertThat(MAX_NUMBER).isLessThan(10);
        assertThat(MIN_NUMBER).isGreaterThan(0);
    }
}