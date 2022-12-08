package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("String 대체")
    void replace() {
        String actual = "abc".replace("b", "d");

        assertThat(actual).isEqualTo("adc");
    }
    @Test
    @DisplayName("String 정규식 기준 분할")
    void split() {
        String given = "1,2";
        String[] result = given.split(",");

        assertThat(result).containsExactly("1","2");
    }
    @Test
    @DisplayName("String 정규식 포함되지 않을 경우 분할")
    void split_one_element() {
        String given = "1";
        String[] result = given.split(",");

        assertThat(result).containsExactly("1");
    }
    @Test
    @DisplayName("String 자르기")
    void substring() {
        String given = "(1,2)";
        String result = given.substring(1, given.length()-1);

        assertThat(result).isEqualTo("1,2");
    }
    @Test
    @DisplayName("String 인덱스 접근")
    void charAt() {
        String given = "abc";

        assertThat(given.charAt(0)).isEqualTo('a');
        assertThat(given.charAt(1)).isEqualTo('b');
        assertThat(given.charAt(2)).isEqualTo('c');
    }
    @Test
    @DisplayName("String 인덱스 올바르지 않을 경우 예외 발생")
    void charAt_out_of_bound() {
        String given = "abc";
        int index = 4;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> given.charAt(index))
            .withMessageMatching("Index \\d+ out of bounds for length \\d+");
    }
}
