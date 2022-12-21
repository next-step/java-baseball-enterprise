package opponent;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

class OpponentTest {

    Opponent opponent = new Opponent();

    @Test
    @DisplayName("chooseAnswer로 반환된 리스트는 크기가 3이어야 한다.")
    void chooseAnswer는_크기가_3인_리스트를_반환한다() {
        // given when
        List<Integer> answer = opponent.chooseAnswer();

        // then
        Assertions.assertThat(answer).hasSize(3);
    }

    @Test
    @DisplayName("chooseAnswer로 반환된 리스트는 서로 다른 숫자로 이루어져 있다.")
    void chooseAnswer는_중복되지_않는_숫자로_이루어진_리스트를_반환한다() {
        // given when
        List<Integer> answer = opponent.chooseAnswer();
        HashSet<Integer> answerSet = new HashSet<>(answer);

        // then
        Assertions.assertThat(answer).hasSameSizeAs(answerSet);
    }
}