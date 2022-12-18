import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    @DisplayName("랜덤 숫자 생성: 자리수 테스트")
    void lengthTest() {
        int[] rands = numberGenerator.getRandomNumbers();
        assertThat(3).isEqualTo(rands.length);
    }

    @Test
    @DisplayName("랜덤 숫자 생성: 일치 여부 테스트")
    void duplicateTest() {
        int[] rands = numberGenerator.getRandomNumbers();
        boolean isDuplicated = rands[0] == rands[1] || rands[1] == rands[2] || rands[2] == rands[0];
        assertThat(false).isEqualTo(isDuplicated);
    }

}
