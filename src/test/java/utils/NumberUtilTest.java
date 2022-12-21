package utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtilTest {

    @DisplayName("매개변수로 int 형식의 문자열이 들어왔을 경우 true 를 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "4", "5", "123", "1252135"})
    void isNumber(String possibleNumber) {
        assertThat(NumberUtil.isNumber(possibleNumber)).isTrue();
    }

    @DisplayName("매개변수로 int 형식이 아닌 문자열이 들어왔을 경우 false 를 반환")
    @ParameterizedTest
    @ValueSource(strings = {"asd", "2 as", "number", "%", "2.2"})
    void isNotNumber(String possibleNumber) {
        assertThat(NumberUtil.isNumber(possibleNumber)).isFalse();
    }

    @DisplayName("int 형식의 문자열을 자릿수 별로 List<Integer> 형식으로 변환한다.")
    @Test
    void toNumberArray() {
        // given
        List<Integer> arr1 = List.of(1, 2, 3);
        List<Integer> arr2 = List.of(6, 4, 2, 1, 2);

        // when
        List<Integer> resultArr1 = NumberUtil.toNumberArray("123");
        List<Integer> resultArr2 = NumberUtil.toNumberArray("64212");

        // then
        assertThat(resultArr1).isEqualTo(arr1);
        assertThat(resultArr2).isEqualTo(arr2);
    }
}
