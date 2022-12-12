package baseball.validator;

public class InputRestartValidator extends Validator{
    private static final String RESTART = "1";
    private static final String QUIT = "2";

    public static Boolean validate(String input) {
        String trimmedInput = removeSpace(input);
        if (trimmedInput.equals(RESTART)){
            return true;
        }
        if (trimmedInput.equals(QUIT)){
            return false;
        }
        throw new IllegalArgumentException();
    }
}
