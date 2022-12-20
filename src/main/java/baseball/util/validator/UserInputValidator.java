package baseball.util.validator;

import baseball.util.exception.DuplicateInputNumberException;
import baseball.util.exception.InputOutOfRangeException;

import java.util.Scanner;

import static baseball.util.constant.NumberConstant.*;

public class UserInputValidator {
    public int validateInput(String input) {
        try {
            validateDuplicateNumber(input);
            int inputNum = Integer.parseInt(input);
            validateInputRange(inputNum, MIN, MAX);
            return inputNum;
        } catch(NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }

    private void validateDuplicateNumber(String input) {
        if(input.length() != input.chars().distinct().count()) {
            throw new DuplicateInputNumberException("중복된 숫자가 존재합니다.");
        }
    }

    private void validateInputRange(int inputNum, int min, int max) {
        if(inputNum < min || inputNum > max) {
            throw new InputOutOfRangeException(String.format("입력값은 %d과 %d 사이여야 합니다.", min, max));
        }
    }

    public Boolean validateEndInputFromUser(String input) {
        try {
            int inputNum = Integer.parseInt(input);
            validateInputRange(inputNum, 1, 2);
            return inputNum == 2;
        } catch(NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }
}
