package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void splitOneAndTwo() {
        String str = "1,2";
        String[] resStr = str.split(",");
        assertThat(resStr).contains("1", "2");
    }

    @Test
    void splitOne() {
        String str = "1";
        String[] resStr = str.split(",");
        assertThat(resStr).containsExactly("1");
    }

    @Test
    void removeParenthesis() {
        String str = "(1,2)";
        String resStr = str.substring(1, 4);
        assertThat(resStr).isEqualTo("1,2");
    }

    @Test
    void strIdxOutOfBound() {
        String str = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            str.charAt(3);
        }).withMessageMatching("Index \\d+ out of bounds for length \\d+");
    }
}
