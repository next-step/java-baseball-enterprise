package baseball.validator;

import baseball.constant.Command;

public class InputRestartValidator extends Validator {
    private static final String restart = Command.RESTART.getValue();
    private static final String quit = Command.QUIT.getValue();
    private static final String INVALID_RESTART_INPUT_ERROR_MESSAGE = "[ERROR] 입력을 확인해주세요.";

    public static Boolean validate(String input) {
        String trimmedInput = removeSpace(input);
        if (trimmedInput.equals(restart)) {
            return true;
        }
        if (trimmedInput.equals(quit)) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_RESTART_INPUT_ERROR_MESSAGE);
    }
}
