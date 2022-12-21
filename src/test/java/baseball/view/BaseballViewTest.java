package baseball.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballViewTest {

    BaseballView baseballView;

    @BeforeEach
    public void beforeEach() {
        baseballView = new BaseballView();
    }

    @DisplayName("입력이 3글자가 아니면 Exception이 발생합니다.")
    @Test
    void isValidLength() {
        String fourLengthInput = "1234";
        assertThrows(
                IllegalArgumentException.class,
                () -> baseballView.validatePlayerInput(fourLengthInput)
        );
    }

    @DisplayName("숫자가 아닌 다른 값이 input으로 들어가면 Exception이 발생합니다.")
    @Test
    void isOnlyNumber() {
        String notOnlyNumberInput = "12#";
        assertThrows(
                IllegalArgumentException.class,
                () -> baseballView.validatePlayerInput(notOnlyNumberInput)
        );
    }

    @DisplayName("중복된 숫자를 입력하면 Exception이 발생합니다.")
    @Test
    void isNotDuplicated() {
        String duplicatedNumberInput = "112";
        assertThrows(
                IllegalArgumentException.class,
                () -> baseballView.validatePlayerInput(duplicatedNumberInput)
        );
    }
}