import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();

    @Test
    void isDigit() {
        String str = "A34-!";

        assertThat(game.isDigit(str, 0)).isFalse();
        assertThat(game.isDigit(str, 1)).isTrue();
        assertThat(game.isDigit(str, 3)).isFalse();
    }

    @Test
    void stringToIntArray() throws Exception {
        assertThat(game.stringToIntArray("325")).containsExactly(3,2,5);

        assertThatThrownBy(()->game.stringToIntArray("ABC"))
            .isInstanceOf(Exception.class)
            .hasMessageContaining("not digit");
    }
}