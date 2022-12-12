package study;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("Split multiple parts")
    void splitMultiple() {
        String source = "1,2";
        String[] actual = source.split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    @DisplayName("Split single part")
    void splitSingle() {
        String source = "1";
        String[] actual = source.split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("test substring")
    void substring() {
        String source = "(1,2)";
        String parenthesisRemoved = source.substring(1, source.length()-1);
        assertThat(parenthesisRemoved).isEqualTo("1,2");
    }
}
