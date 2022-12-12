package baseball.validator;

public class InputRestartValidator extends Validator {
    private static final String RESTART = "1";
    private static final String QUIT = "2";
    private static final String INVALID_RESTART_INPUT_ERROR_MESSAGE = "[ERROR] 입력을 확인해주세요.";

    public static Boolean validate(String input) {
        String trimmedInput = removeSpace(input);
        if (trimmedInput.equals(RESTART)) {
            return true;
        }
        if (trimmedInput.equals(QUIT)) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_RESTART_INPUT_ERROR_MESSAGE);
    }
}
