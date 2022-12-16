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
		String[] oneTwo = "1,2".split(",");
		assertThat(oneTwo).contains("1", "2");

		String[] one = "1".split(",");
		assertThat(one).containsExactly("1");
	}

	@Test
	void trimBracket() {
		String bracket = "(1,2)";
		String trim = bracket.substring(1, bracket.length()-1);
		assertThat(trim).isEqualTo("1,2");
	}

	@Test
	@DisplayName("문자열 인덱스 범위 초과시 exception 확인")
	void exceptionThrow() {
		String abc = "abc";
		assertThatThrownBy(()-> {
			abc.charAt(10);
		})
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("out of bounds");
	}
}
