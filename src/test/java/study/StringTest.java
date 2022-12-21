package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIndexOutOfBoundsException;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void test1() {
        String[] split_test1 = "1,2".split(",");
        assertThat(split_test1).containsExactly("1","2");

        String[] split_test2 = "1".split(",");
        assertThat(split_test2).containsExactly("1");
    }

    @Test
    void test2() {
        String test = "(1,2)";
        String substring_test = test.substring(1, test.length()-1);
        assertThat(substring_test).isEqualTo("1,2");
    }

    @Test
    void test3_1() {
        String test = "abc";
        assertThat(test.charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("Test string charAt exception")
    void test3_2() {
        String test = "abc";
        assertThatIndexOutOfBoundsException().isThrownBy(() ->{
            test.charAt(4);
        }).withFailMessage("Index: \\d+");
    }
}
