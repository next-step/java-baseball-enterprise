package baseball.view;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import baseball.controller.BaseballController;
import baseball.domain.BaseballNumber;
import baseball.dto.BaseballResultDto;
import baseball.service.BaseballService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballViewTest {

    private BaseballView baseballView;

    @BeforeEach
    public void beforeEach() {
        BaseballNumber baseballNumber = new BaseballNumber();
        BaseballService baseballService = new BaseballService(baseballNumber);
        BaseballController baseballController = new BaseballController(baseballService);
        baseballView = new BaseballView(baseballController);
    }

    @DisplayName("입력이 3글자가 아니면 Exception이 발생합니다.")
    @Test
    void isValidLength() {
        // given
        String fourLengthInput = "1234";

        // when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> baseballView.validatePlayerInput(fourLengthInput)
        );
    }

    @DisplayName("숫자가 아닌 다른 값이 input으로 들어가면 Exception이 발생합니다.")
    @Test
    void isOnlyNumber() {
        // given
        String notOnlyNumberInput = "12#";

        // when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> baseballView.validatePlayerInput(notOnlyNumberInput)
        );
    }

    @DisplayName("중복된 숫자를 입력하면 Exception이 발생합니다.")
    @Test
    void isNotDuplicated() {
        // given
        String duplicatedNumberInput = "112";

        // when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> baseballView.validatePlayerInput(duplicatedNumberInput)
        );
    }

    @DisplayName("하나도 맞지 않으면 '낫싱'이 반환됩니다.")
    @Test
    void getBaseballResultString() {
        // given
        BaseballResultDto baseballResultDto = new BaseballResultDto(0, 0);

        // when
        String resultString = baseballView.getBaseballResultString(baseballResultDto);

        // then
        assertThat(resultString).isEqualTo("낫싱");
    }

    @DisplayName("스트라이크가 0이 아니면 스트라이크에 대한 정보가 포함됩니다.")
    @Test
    void getStrikeString() {
        // given
        BaseballResultDto baseballResultDto = new BaseballResultDto(1, 0);

        // when
        String resultString = baseballView.getBaseballResultString(baseballResultDto);

        // then
        assertThat(resultString).contains("스트라이크");
    }

    @DisplayName("볼이 0이 아니면 볼에 대한 정보가 포함됩니다.")
    @Test
    void getBallString() {
        // given
        BaseballResultDto baseballResultDto = new BaseballResultDto(0, 1);

        // when
        String resultString = baseballView.getBaseballResultString(baseballResultDto);

        // then
        assertThat(resultString).contains("볼");
    }
}