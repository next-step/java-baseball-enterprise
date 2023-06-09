package baseball.view;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Numbers;
import baseball.testdoubles.SpyOutputStream;
import baseball.testdoubles.StubInputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ViewTest {

    @DisplayName("정해진 길이를 넘어선 숫자를 입력할 수 없다.")
    @Test
    void inputOverLengthNumbers() {
        SpyOutputStream spyOutputStream = new SpyOutputStream();
        StubInputStream stubInputStream = new StubInputStream("1234", "123");
        View view = new View(new PrintStream(spyOutputStream), stubInputStream);

        Numbers actual = view.inputNumbers();

        assertThat(actual).isEqualTo(Numbers.from("123"));
        assertThat(spyOutputStream.getPrintedTexts())
                .contains(inputNumbersErrorMessage("1234"));
    }

    @DisplayName("중복된 숫자를 입력할 수 없다.")
    @Test
    void inputDuplicatedNumbers() {
        SpyOutputStream spyOutputStream = new SpyOutputStream();
        StubInputStream stubInputStream = new StubInputStream("121", "123");
        View view = new View(new PrintStream(spyOutputStream), stubInputStream);

        Numbers actual = view.inputNumbers();

        assertThat(actual).isEqualTo(Numbers.from("123"));
        assertThat(spyOutputStream.getPrintedTexts())
                .contains(inputNumbersErrorMessage("121"));
    }

    @DisplayName("숫자외의 글자를 입력할 수 없다.")
    @Test
    void inputWords() {
        SpyOutputStream spyOutputStream = new SpyOutputStream();
        StubInputStream stubInputStream = new StubInputStream("12a", "123");
        View view = new View(new PrintStream(spyOutputStream), stubInputStream);

        Numbers actual = view.inputNumbers();

        assertThat(actual).isEqualTo(Numbers.from("123"));
        assertThat(spyOutputStream.getPrintedTexts())
                .contains(inputNumbersErrorMessage("12a"));
    }

    @DisplayName("잘못된 명령어 번호는 입력할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "a", "12"})
    void inputInvalidCommandNumber(String invalidCommand) {
        SpyOutputStream spyOutputStream = new SpyOutputStream();
        StubInputStream stubInputStream = new StubInputStream(invalidCommand, "1");
        View view = new View(new PrintStream(spyOutputStream), stubInputStream);

        Command actual = view.inputCommand();

        assertThat(actual).isEqualTo(Command.NEW_GAME);
        assertThat(spyOutputStream.getPrintedTexts())
                .contains(inputCommandErrorMessage(invalidCommand));
    }

    private String inputNumbersErrorMessage(String inputValue) {
        return String.format("[입력값 : %s] 중복이 없는 3자리 숫자만 가능합니다.", inputValue);
    }

    private String inputCommandErrorMessage(String inputValue) {
        return String.format("[입력값 : %s]에 맞는 명령어가 없습니다.", inputValue);
    }
}
