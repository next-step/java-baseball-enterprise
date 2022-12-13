package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String s1 = "1,2";
        String[] arr1 = s1.split(",");
        assertThat(arr1).contains("1", "2");

        String s2 = "1";
        String[] arr2 = s2.split(",");
        assertThat(arr2).containsExactly("1");
    }

    void substring() {
        String s1 = "(1,2)";
        s1.substring(1, 4);
    }

    @DisplayName("charAt Test")
    @Test
    void charAtTest() {
        String s1 = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    s1.charAt(5);
                }).withMessageMatching("Index \\d+ out of bounds for length \\d+");
    }


}
