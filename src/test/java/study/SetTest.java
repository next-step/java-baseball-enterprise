package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.HashSet;
import java.util.Set;

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
    @DisplayName("Set 크기")
    void set_size() {
        assertThat(numbers.size()).isEqualTo(3);
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set 포함 여부 확인")
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set 포함 여부 true, false 확인")
    void contains_with_false(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }
}
