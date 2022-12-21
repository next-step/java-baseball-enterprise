package baseball.util.validator;

import baseball.util.exception.DuplicateInputNumberException;
import baseball.util.exception.InputOutOfRangeException;
import baseball.util.exception.InvalidInputException;

public final class UserInputValidator {

    public static void validate(String input) {
        validateInputIsNumeric(input);
        validateDuplicateNumber(input);
        validateNotExistZero(input);
        validateOutOfRange(input);
    }

    public static boolean validateAndIsTwo(int input) {
        validateIsOneOrTwo(input);
        return input == 2;
    }

    private static void validateIsOneOrTwo(int input) {
        if(input != 1 && input != 2) {
            throw new NumberFormatException("올바른 숫자를 입력해주세요.");
        }
    }

    private static void validateInputIsNumeric(String input) {
        if(!input.matches("^[0-9]\\d*(\\.\\d+)?$")) {
            throw new NumberFormatException("올바른 숫자를 입력해주세요.");
        }
    }

    private static void validateOutOfRange(String input) {
        if(input.length() != 3) {
            throw new InputOutOfRangeException("올바르지 않은 수 크기입니다.");
        }
    }

    private static void validateNotExistZero(String input) {
        if(input.contains("0")) {
            throw new InvalidInputException("숫자에 0이 포함될 수 없습니다.");
        }
    }

    private static void validateDuplicateNumber(String input) {
        if(input.length() != input.chars().distinct().count()) {
            throw new DuplicateInputNumberException("중복된 숫자가 존재합니다.");
        }
    }
}
