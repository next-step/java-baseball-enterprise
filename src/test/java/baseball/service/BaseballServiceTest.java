package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BaseballNumber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballServiceTest {

    private BaseballNumber baseballNumber;
    private BaseballService baseballService;

    @BeforeEach
    public void beforeEach() {
        baseballNumber = new BaseballNumber();
        baseballService = new BaseballService(baseballNumber);
        baseballService.startGame();
    }

    @DisplayName("볼의 갯수를 계산할 수 있습니다.")
    @Test
    void getBallCount() {
        // given
        List<Integer> userBaseballNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> computerBaseballNumber = new ArrayList<>(Arrays.asList(1, 3, 2));
        baseballService.setBaseballNumber(computerBaseballNumber);

        // when & then
        assertThat(baseballService.getBallCount(userBaseballNumber)).isEqualTo(2);

    }

    @DisplayName("스트라이크의 갯수를 계산할 수 있습니다.")
    @Test
    void getStrikeCount() {
        // given
        List<Integer> userBaseballNumber = new ArrayList<>(Arrays.asList(1, 2, 4));
        List<Integer> computerBaseballNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        baseballService.setBaseballNumber(computerBaseballNumber);

        // when & then
        assertThat(baseballService.getStrikeCount(userBaseballNumber)).isEqualTo(2);
    }
}