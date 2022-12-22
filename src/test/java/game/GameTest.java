package game;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    void randomGame() {
        for (int i = 0; i < 1000; i++) {
            var game = Game.randomGame();
            assertThat(game.actualValues)
                    .isNotNull() // null 확인
                    .hasSize(3) // 크기는 항상 3
                    .doesNotHaveDuplicates() // 동일 엘리먼트 없어야 함
                    .satisfies((arr) -> { // 각 요소는 1~9 사이
                        for (var elem : arr) {
                            assertThat(elem)
                                    .isGreaterThanOrEqualTo(1)
                                    .isLessThanOrEqualTo(9);
                        }
                    });
        }
    }

    @Test
    void expectedGame() {
        var picks = Game.randomPick();
        var game = Game.expectedGame(picks[0], picks[1], picks[2]);
        assertThat(game.actualValues).isEqualTo(picks);
    }

    @Test
    void calculateGameResults() {
        var picks = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(picks);
        var game = Game.expectedGame(picks.get(0), picks.get(1), picks.get(2));
        // 3 스트라이크
        var s3b0n0 = game.calculateGameResults(new int[]{picks.get(0), picks.get(1), picks.get(2)});
        assertThat(s3b0n0.strike).isEqualTo(3);
        assertThat(s3b0n0.ball).isEqualTo(0);
        // 2 스트라이크
        var s2b0n1 = game.calculateGameResults(new int[]{picks.get(0), picks.get(1), picks.get(3)});
        assertThat(s2b0n1.strike).isEqualTo(2);
        assertThat(s2b0n1.ball).isEqualTo(0);
        // 1 스트라이크, 2볼
        var s1b2n0 = game.calculateGameResults(new int[]{picks.get(0), picks.get(2), picks.get(1)});
        assertThat(s1b2n0.strike).isEqualTo(1);
        assertThat(s1b2n0.ball).isEqualTo(2);
        // 1 스트라이크, 1볼
        var s1b1n0 = game.calculateGameResults(new int[]{picks.get(0), picks.get(2), picks.get(3)});
        assertThat(s1b1n0.strike).isEqualTo(1);
        assertThat(s1b1n0.ball).isEqualTo(1);
        // 1 스트라이크
        var s1b0n1 = game.calculateGameResults(new int[]{picks.get(0), picks.get(3), picks.get(4)});
        assertThat(s1b0n1.strike).isEqualTo(1);
        assertThat(s1b0n1.ball).isEqualTo(0);
        // 3볼
        var s0b3n0 = game.calculateGameResults(new int[]{picks.get(2), picks.get(0), picks.get(1)});
        assertThat(s0b3n0.strike).isEqualTo(0);
        assertThat(s0b3n0.ball).isEqualTo(3);
        // 2볼
        var s0b2n1 = game.calculateGameResults(new int[]{picks.get(2), picks.get(0), picks.get(3)});
        assertThat(s0b2n1.strike).isEqualTo(0);
        assertThat(s0b2n1.ball).isEqualTo(2);
        // 1볼
        var s0b1n2 = game.calculateGameResults(new int[]{picks.get(2), picks.get(4), picks.get(3)});
        assertThat(s0b1n2.strike).isEqualTo(0);
        assertThat(s0b1n2.ball).isEqualTo(1);
        // 낫씽
        var s0b0n3 = game.calculateGameResults(new int[]{picks.get(5), picks.get(4), picks.get(3)});
        assertThat(s0b0n3.strike).isEqualTo(0);
        assertThat(s0b0n3.ball).isEqualTo(0);
    }
}
