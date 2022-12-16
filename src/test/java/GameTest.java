import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    private Game game = new Game();

    @ParameterizedTest
    @ValueSource(chars = {'1','2','3','4','5','6','7','8','9'})
    void validateCharacter(char ch) {
        assertThatNoException()
                .isThrownBy(() -> game.validateCharacter(ch));
    }

    @ParameterizedTest
    @ValueSource(chars = {'0','A','!','@','*'})
    void validateCharacter_throw_exception(char ch) {
        assertThatThrownBy(() -> game.validateCharacter(ch))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("character");
    }

    @Test
    void validate() {
        String input = "256";

        assertThatNoException()
                .isThrownBy(() -> game.validate(input));
    }

    @Test
    void validate_throw_exception() {
        String input = "7336";

        assertThatThrownBy(() -> game.validate(input))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("length");
    }

    @Test
    void inputToNumbers() throws Exception {
        String input = "325";

        assertThat(game.inputToNumbers(input))
                .containsExactly(3,2,5);
    }
}