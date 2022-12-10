package baseball.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringListIntegerConvertorTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "030", "111", "98654", "43783921", "1"})
    void convert_success(String input) {
        List<Integer> result = StringListIntegerConvertor.convert(input);
        assertThat(result).hasSize(input.length());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1 1", "1, 2, 3", "-1", "-43783921", "deadbeef", "cafebebe"})
    void convert_fail(String input) {
        assertThatThrownBy(() -> StringListIntegerConvertor.convert(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}