package baseball;

import baseball.util.util.NumberUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static baseball.util.constant.NumberConstant.*;
import static org.assertj.core.api.Assertions.*;

public class RandomNumberTest {

    private List<Integer> numbers;
    @BeforeEach
    public void setUp() {
        numbers = NumberUtils.generateRandomUniqueIntegerList(RANDOM_NUMBER_SIZE, RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }

    @Test
    @DisplayName("랜덤하게 뽑힌 수는 유니크해야함")
    public void uniqueNumber() {
        assertThat(new HashSet<>(numbers).size()).isEqualTo(numbers.size());
    }

    @Test
    @DisplayName("랜덤하게 뽑힌 수는 MIN ~ MAX 사이 값이여야 함")
    public void validRangeNumber() {
        assertThat(Collections.max(numbers)).isLessThanOrEqualTo(RANDOM_NUMBER_MAX);
        assertThat(Collections.min(numbers)).isGreaterThanOrEqualTo(RANDOM_NUMBER_MIN);
    }
}
