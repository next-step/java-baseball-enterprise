import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {
    NumberGenerator numberGenerator = new NumberGenerator();
    int[] numbers;

    @BeforeEach
    void setup() {
        numbers = numberGenerator.generate();
        assertThat(numbers).isNotNull();
    }

    @Test
    @DisplayName("Generate random numbers")
    void numbersSize() {
        assertThat(numbers.length).isEqualTo(3);
    }

    @Test
    @DisplayName("Generated numbers should not be duplicated")
    void numbersDuplication() {
        assertThat(numbers[0]).isNotEqualTo(numbers[1]);
        assertThat(numbers[0]).isNotEqualTo(numbers[2]);
        assertThat(numbers[1]).isNotEqualTo(numbers[2]);
    }
}
