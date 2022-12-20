package utils;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void toNumberArray() {
    }
}
