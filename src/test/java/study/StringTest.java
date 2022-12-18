package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        //given
        String str = "1,2";
        //when
        String[] arr = str.split(",");
        //then
        assertThat(arr).contains("1");
        assertThat(arr).contains("2");
    }

    @Test
    void split2() {
        //given
        String str = "1";
        //when
        String[] arr = str.split(",");
        //then
        assertThat(arr).containsExactly("1");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        String result = str.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 테스트")
    void charAt() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
