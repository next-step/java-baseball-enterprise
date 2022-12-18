package baseball.domain;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberTest {

    BaseballNumber baseballNumber;

    @BeforeEach
    public void beforeEach() {
        baseballNumber = new BaseballNumber();
    }

    @DisplayName("생성되는 숫자의 범위는 1-9이다.")
    @Test
    void GenerateBaseballNumbersTest() {
        // given
        baseballNumber.GenerateBaseballNumbers();

        // when
        List<Integer> numbers = baseballNumber.getNumbers();

        // then
        assertThat(numbers.stream().allMatch(v -> 1 <= v && v <= 9)).isTrue();

    }
}
