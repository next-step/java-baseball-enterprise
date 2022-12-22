package baseball.util.validator;

import baseball.util.exception.DuplicateInputNumberException;
import baseball.util.exception.InputOutOfRangeException;
import baseball.util.exception.InvalidInputException;

import static baseball.util.constant.ExceptionMessageConstant.*;

public final class UserInputValidator {

    public static void validate(String input) {
        validateInputIsNumeric(input);
        validateDuplicateNumber(input);
        validateNotExistZero(input);
        validateOutOfRange(input);
    }

    public static boolean validate(int input) {
        validateIsOneOrTwo(input);
        return input == 2;
    }

    private static void validateIsOneOrTwo(int input) {
        if(input != 1 && input != 2) {
            throw new InvalidInputException(INVALID_INPUT_EXCEPTION);
        }
    }

    private static void validateInputIsNumeric(String input) {
        if(!input.matches("^[0-9]\\d*(\\.\\d+)?$")) {
            throw new InvalidInputException(INVALID_INPUT_EXCEPTION);
        }
    }

    private static void validateOutOfRange(String input) {
        if(input.length() != 3) {
            throw new InputOutOfRangeException(OUT_OF_RANGE_EXCEPTION);
        }
    }

    private static void validateNotExistZero(String input) {
        if(input.contains("0")) {
            throw new InvalidInputException(INVALID_INPUT_EXCEPTION);
        }
    }

    private static void validateDuplicateNumber(String input) {
        if(input.length() != input.chars().distinct().count()) {
            throw new DuplicateInputNumberException(DUPLICATED_NUMBER_EXCEPTION);
        }
    }
}
