package study;

import org.junit.jupiter.api.*;

import java.util.Set;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Test set size")
    void setSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }
}
