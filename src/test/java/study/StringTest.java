package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("String 치환")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("String \',\'로 split")
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String 문자 하나일때 split")
    void splitOne() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("String 앞뒤 자르기")
    void splitBracket() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 인덱스 접근")
    void getChar() {
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
    }

    @Test
    @DisplayName("String 인덱스 벗어날 때 예외 처리")
    void getCharException() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char actual = "abc".charAt(3);
                }).withMessageMatching("Index \\d+ out of bounds for length \\d+");
    }
}
