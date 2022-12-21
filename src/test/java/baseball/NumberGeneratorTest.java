package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class NumberGeneratorTest {

    @Test
    public void isLengthOf3() {
        List<Integer> generated = NumberGenerater.generate();

        assertThat(generated).hasSize(3);
    }
    @Test
    public void isGeneratingDistinctNumbers() {
        List<Integer> generated = NumberGenerater.generate();

        assertThat(generated.get(0)).isNotEqualTo(generated.get(1));
        assertThat(generated.get(1)).isNotEqualTo(generated.get(2));
        assertThat(generated.get(2)).isNotEqualTo(generated.get(0));
    }
}
