import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OpponentTest {

    private final Opponent opponent = new Opponent();

    @BeforeEach
    void setAnswer() {
        try {
            Field answer = Opponent.class.getDeclaredField("answer");
            answer.setAccessible(true);
            List<Integer> providedAnswer = List.of(1, 2, 3);
            answer.set(opponent, providedAnswer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("스트라이크를 계산한다.")
    @Test
    void countStrikes() {
        // given
        List<Integer> guess1 = List.of(1, 2, 3);
        List<Integer> guess2 = List.of(1, 2, 4);
        List<Integer> guess3 = List.of(6, 2, 3);
        List<Integer> guess4 = List.of(4, 1, 6);
        List<Integer> guess5 = List.of(5, 8, 9);
        List<Integer> guess6 = List.of(1, 8, 9);
        List<Integer> guess7 = List.of(5, 2, 9);

        // when
        int result1 = opponent.countStrikes(guess1);
        int result2 = opponent.countStrikes(guess2);
        int result3 = opponent.countStrikes(guess3);
        int result4 = opponent.countStrikes(guess4);
        int result5 = opponent.countStrikes(guess5);
        int result6 = opponent.countStrikes(guess6);
        int result7 = opponent.countStrikes(guess7);

        // then
        assertThat(result1).isEqualTo(3);
        assertThat(result2).isEqualTo(2);
        assertThat(result3).isEqualTo(2);
        assertThat(result4).isEqualTo(0);
        assertThat(result5).isEqualTo(0);
        assertThat(result6).isEqualTo(1);
        assertThat(result7).isEqualTo(1);
    }

    @DisplayName("볼을 계산한다.")
    @Test
    void countBalls() {
        // given
        List<Integer> guess1 = List.of(1, 2, 3);
        List<Integer> guess2 = List.of(1, 2, 4);
        List<Integer> guess3 = List.of(3, 6, 2);
        List<Integer> guess4 = List.of(4, 1, 2);
        List<Integer> guess5 = List.of(3, 1, 2);
        List<Integer> guess6 = List.of(7, 2, 1);
        List<Integer> guess7 = List.of(5, 9, 2);

        // when
        int result1 = opponent.countBalls(guess1);
        int result2 = opponent.countBalls(guess2);
        int result3 = opponent.countBalls(guess3);
        int result4 = opponent.countBalls(guess4);
        int result5 = opponent.countBalls(guess5);
        int result6 = opponent.countBalls(guess6);
        int result7 = opponent.countBalls(guess7);

        // then
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(0);
        assertThat(result3).isEqualTo(2);
        assertThat(result4).isEqualTo(2);
        assertThat(result5).isEqualTo(3);
        assertThat(result6).isEqualTo(1);
        assertThat(result7).isEqualTo(1);
    }
}
