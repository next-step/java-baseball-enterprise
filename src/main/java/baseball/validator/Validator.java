package baseball.validator;

public abstract class Validator {
    static Object validate(String input) throws IllegalArgumentException {
        return null;
    }

    static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
}
