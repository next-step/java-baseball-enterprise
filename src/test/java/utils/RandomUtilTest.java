package utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomUtilTest {

    @DisplayName("파라미터로 주어진 개수만큼의 배열을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 300})
    void generateRandomNumbers(int length) {
        List<Integer> arr = RandomUtil.generateRandomNumbers(length);
        assertThat(arr.size()).isEqualTo(length);
    }
}
