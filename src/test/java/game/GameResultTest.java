package game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @Test
    void isAllStrike() {
        var r0 = new GameResult(0, 3);
        assertThat(r0.isAllStrike()).isEqualTo(true);
        var r1 = new GameResult(1, 2);
        assertThat(r1.isAllStrike()).isEqualTo(false);
    }
    @Test
    void isNothing() {
        var r0 = new GameResult(0, 0);
        assertThat(r0.isNothing()).isEqualTo(true);
        var r1 = new GameResult(1, 2);
        assertThat(r1.isNothing()).isEqualTo(false);
    }
    @Test
    void testToString() {
        var r0 = new GameResult(0, 0);
        assertThat(r0.toString()).isEqualTo("nothing");
        var r1 = new GameResult(0, 3);
        assertThat(r1.toString()).isEqualTo("all strike");
        var r2 = new GameResult(1, 2);
        assertThat(r2.toString()).isEqualTo("2 strike, 1 ball");
        var r3 = new GameResult(2, 1);
        assertThat(r3.toString()).isEqualTo("1 strike, 2 ball");
    }
}
