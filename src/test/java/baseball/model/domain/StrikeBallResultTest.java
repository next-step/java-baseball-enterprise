package baseball.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StrikeBallResultTest {

    @DisplayName("정적 팩터리 메서드로 Strike, Ball 결과를 생성한다.")
    @Test
    void create() {
        // given & when
        StrikeBallResult strikeBallResult = StrikeBallResult.of(1, 2);

        // then
        assertThat(strikeBallResult.getStrike()).isEqualTo(1);
        assertThat(strikeBallResult.getBall()).isEqualTo(2);
    }

    @DisplayName("List를 통해 만들어둔 StrikeBallResult를 합한 StrikeBallResult를 만들 수 있다.")
    @Test
    void addAll() {
        // given
        StrikeBallResult strikeBallResult1 = StrikeBallResult.of(2, 1);
        StrikeBallResult strikeBallResult2 = StrikeBallResult.of(1, 2);
        StrikeBallResult strikeBallResult3 = StrikeBallResult.of(1, 1);

        // when
        List<StrikeBallResult> strikeBallResults = List.of(strikeBallResult1, strikeBallResult2, strikeBallResult3);

        // then
        StrikeBallResult strikeBallResult = StrikeBallResult.addAll(strikeBallResults);
        assertThat(strikeBallResult.getStrike()).isEqualTo(4);
        assertThat(strikeBallResult.getBall()).isEqualTo(4);
    }
}