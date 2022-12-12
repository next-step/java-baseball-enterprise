package baseball.view;

import baseball.domain.BaseballNumbers;
import baseball.validator.InputRestartValidator;
import baseball.validator.InputUserAnswerValidator;

import java.util.Scanner;

public class InputView {
    private final String INPUT_ANSWER_STRING = "숫자를 입력해주세요 : ";
    private final String INPUT_RESTART_STRING = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public BaseballNumbers readInputUserAnswer() {
        System.out.print(INPUT_ANSWER_STRING);
        try {
            return InputUserAnswerValidator.validate(sc.next());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readInputUserAnswer();
        }
    }

    public boolean readInputRestart() {
        System.out.println(INPUT_RESTART_STRING);
        try {
            return InputRestartValidator.validate(sc.next());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readInputRestart();
        }
    }
}
