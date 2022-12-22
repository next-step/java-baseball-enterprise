package UI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputUITest {

    @Test
    @DisplayName("사용자가 입력한 답은 숫자로만 이루어져 있는가?")
    void checkUserInputIsNum() {
        inputStringToStream("123");
        String userInput = InputUI.getAnswerByUser(3);

        for (int i = 0; i < userInput.length(); i++) {
            assertThat(userInput.charAt(i)).isBetween('1', '9');
        }
    }

    @Test
    @DisplayName("사용자가 입력한 답은 세자리 수인가?")
    void checkUserInput() {
        inputStringToStream("456");
        String userInput = InputUI.getAnswerByUser(3);

        assertThat(userInput.length()).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자가 입력한 답은 서로 다른 수로 이루어져 있는가?")
    void test() {
        inputStringToStream("789");
        String userInput = InputUI.getAnswerByUser(3);

        assertThat(checkDuplication(userInput)).isTrue();
    }

    private void inputStringToStream(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    private boolean checkDuplication(String str) {
        if (str.charAt(0) == str.charAt(1)) return false;
        if (str.charAt(1) == str.charAt(2)) return false;
        if (str.charAt(0) == str.charAt(2)) return false;
        return true;
    }
}