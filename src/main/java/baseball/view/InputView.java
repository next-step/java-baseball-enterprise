package baseball.view;

import baseball.constant.Command;
import baseball.domain.BaseballNumbers;
import baseball.validator.InputRestartValidator;
import baseball.validator.InputUserAnswerValidator;

import java.util.Scanner;

public class InputView {
    private final String INPUT_ANSWER_MESSAGE = "숫자를 입력해주세요 : ";
    private final String INPUT_RESTART_MESSAGE_FORMAT = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.";
    private final String INPUT_RESTART_MESSAGE = String.format(INPUT_RESTART_MESSAGE_FORMAT,
            Command.RESTART.getValue(), Command.QUIT.getValue());
    private final Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public BaseballNumbers readInputUserAnswer() {
        System.out.print(INPUT_ANSWER_MESSAGE);
        try {
            return InputUserAnswerValidator.validate(sc.next());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readInputUserAnswer();
        }
    }

    public boolean readInputRestart() {
        System.out.println(INPUT_RESTART_MESSAGE);
        try {
            return InputRestartValidator.validate(sc.next());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readInputRestart();
        }
    }
}
