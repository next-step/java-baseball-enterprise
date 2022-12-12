package baseball.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomBaseballNumberGeneratorTest {

    @DisplayName("랜덤하게 BaseballNumber를 생성할 수 있다.")
    @Test
    void create() {
        assertDoesNotThrow(() -> RandomBaseballNumberGenerator.create());
    }
}
