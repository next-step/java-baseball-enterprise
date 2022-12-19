package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {
    BaseballGame baseballGame = new BaseballGame(createBaseballNumbers("123"));

    @DisplayName("inputUserAnswer가 1~9로 이루어진 세 자리의 수인 경우 BaseballNumbers를 정상적으로 반환한다.")
    @Test
    void BaseballGame_Judge_테스트() {
        assertThat(baseballGame.getResult(createBaseballNumbers("456")))
                .isEqualTo(StrikeBallCountCombination.count_00.getStrikeBallCount());
        assertThat(baseballGame.getResult(createBaseballNumbers("436")))
                .isEqualTo(StrikeBallCountCombination.count_01.getStrikeBallCount());
        assertThat(baseballGame.getResult(createBaseballNumbers("237")))
                .isEqualTo(StrikeBallCountCombination.count_02.getStrikeBallCount());
        assertThat(baseballGame.getResult(createBaseballNumbers("312")))
                .isEqualTo(StrikeBallCountCombination.count_03.getStrikeBallCount());
        assertThat(baseballGame.getResult(createBaseballNumbers("156")))
                .isEqualTo(StrikeBallCountCombination.count_10.getStrikeBallCount());
        assertThat(baseballGame.getResult(createBaseballNumbers("134")))
                .isEqualTo(StrikeBallCountCombination.count_11.getStrikeBallCount());
        assertThat(baseballGame.getResult(createBaseballNumbers("132")))
                .isEqualTo(StrikeBallCountCombination.count_12.getStrikeBallCount());
        assertThat(baseballGame.getResult(createBaseballNumbers("124")))
                .isEqualTo(StrikeBallCountCombination.count_20.getStrikeBallCount());
        //assertThat(baseballGame.getResult(createBaseballNumbers("124")))
        //        .isEqualTo(StrikeBallCountCombination.count_21.getStrikeBallCount());
        //2스트라이크 1볼은 불가능
        assertThat(baseballGame.getResult(createBaseballNumbers("123")))
                .isEqualTo(StrikeBallCountCombination.count_30.getStrikeBallCount());
    }

    private BaseballNumbers createBaseballNumbers(String numbers) {
        return new BaseballNumbers(numbers.split(""));
    }
}

