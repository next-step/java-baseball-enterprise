package study.baseball.engine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import study.baseball.engine.model.Numbers;

class NumberGeneratorTest {
    private final NumberGenerator numberGenerator = new NumberGenerator();

    @Test
    public void testGenerateRandomNumbers() {
        for (int i = 0; i < 10; i++) {
            Numbers random = numberGenerator.generateRandomNumber();
            assertThat(random.getNumbers()).hasSize(3);
            for (Integer integer : random.getNumbers()) {
                assertThat(integer).isLessThan(10).isGreaterThanOrEqualTo(0);
            }
        }
    }
}