package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class BaseballNumberTest {

    @DisplayName("두개의 BaseballNumber를 비교할 수 있다.")
    @Test
    void compare() {
        // given
        BaseballNumber original = new BaseballNumber(7,1,3);
        BaseballNumber input1 = new BaseballNumber(1,2,3);
        BaseballNumber input2 = new BaseballNumber(1,4,5);
        BaseballNumber input3 = new BaseballNumber(6,7,1);

        // when
        StrikeBallResult strikeBallResult1 = original.compare(input1);
        StrikeBallResult strikeBallResult2 = original.compare(input2);
        StrikeBallResult strikeBallResult3 = original.compare(input3);

        // then
        assertThat(strikeBallResult1.getStrike()).isEqualTo(1);
        assertThat(strikeBallResult1.getBall()).isEqualTo(1);

        assertThat(strikeBallResult2.getStrike()).isEqualTo(0);
        assertThat(strikeBallResult2.getBall()).isEqualTo(1);

        assertThat(strikeBallResult3.getStrike()).isEqualTo(0);
        assertThat(strikeBallResult3.getBall()).isEqualTo(2);
    }
}