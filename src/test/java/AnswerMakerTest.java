import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerMakerTest {
    private final AnswerMaker answerMaker;

    public AnswerMakerTest() {
        this.answerMaker = new RandomAnswerMaker();
    }

    @Test
    @DisplayName("생성된 수는 모두 다른 수로 이루어져있는가?")
    public void checkDuplicationInAnswer() {
        String answer = answerMaker.makeAnswer(3);

        assertThat(checkDuplication(answer)).isTrue();
    }

    @Test
    @DisplayName("생성된 수는 세자리 수인가?")
    public void checkAnswerSize() {
        String answer = answerMaker.makeAnswer(3);

        assertThat(answer.length()).isEqualTo(3);
    }

    private boolean checkDuplication(String str) {
        if (str.charAt(0) == str.charAt(1)) return false;
        if (str.charAt(1) == str.charAt(2)) return false;
        if (str.charAt(0) == str.charAt(2)) return false;
        return true;
    }

}
