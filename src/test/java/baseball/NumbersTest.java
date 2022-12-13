package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @DisplayName("숫자로만 생성 가능하다.")
    @Test
    void shouldContainsOnlyNumber() {
        assertThatThrownBy(() -> Numbers.from("a23"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3자리 숫자만 생성 가능하다.")
    @Test
    void shouldContainsThreeNumber() {
        assertThatThrownBy(() -> Numbers.from("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자는 불가능하다.")
    @Test
    void shouldContainsDistinctNumber() {
        assertThatThrownBy(() -> Numbers.from("121"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
