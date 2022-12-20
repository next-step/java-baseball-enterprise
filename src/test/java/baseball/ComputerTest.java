package baseball;

import baseball.domain.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

    private List<Integer> numbers;
    private Computer computer = new Computer();
    @BeforeEach
    public void setUp() {
        numbers = computer.generateNumberList();
    }

    @Test
    @DisplayName("랜덤하게 뽑힌 수는 총 10가지여야함")
    public void uniqueNumber() {
        assertThat(new HashSet<>(numbers).size()).isEqualTo(numbers.size());
    }

    @Test
    @DisplayName("랜덤하게 뽑힌 수는 1 ~ 9 사이 값이여야 함")
    public void validRangeNumber() {
        assertThat(Collections.max(numbers)).isLessThanOrEqualTo(9);
        assertThat(Collections.min(numbers)).isGreaterThanOrEqualTo(1);
    }
}
