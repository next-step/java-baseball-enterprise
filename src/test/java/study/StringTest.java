package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitWithContains() {
        String actual = "1,2";
        String resultString[] = actual.split(",");
        assertThat(resultString).contains("1", "2");
    }

    @Test
    void splitWithContainsExactly() {
        String actual = "1";
        String resultString[] = actual.split(",");
        assertThat(resultString).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)";
        assertThat(actual.substring(1, actual.length() - 1)).isEqualTo("1,2");
    }
}
