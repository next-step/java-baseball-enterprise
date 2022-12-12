package baseball.controller.request;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumberRequest {

    private final int firstDigit;
    private final int secondDigit;
    private final int thirdDigit;

    public BaseballNumberRequest(int firstDigit, int secondDigit, int thirdDigit) {
        this.firstDigit = firstDigit;
        this.secondDigit = secondDigit;
        this.thirdDigit = thirdDigit;
    }

    public BaseballNumberRequest(String userInput) {
        validateUserInput(userInput);
        char[] digits = userInput.toCharArray();
        validateDuplicate(digits);
        this.firstDigit = convertCharToInt(digits[0]);
        this.secondDigit = convertCharToInt(digits[1]);
        this.thirdDigit = convertCharToInt(digits[2]);
    }

    private void validateUserInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
        }
    }

    private void validateDuplicate(char[] digits) {
        Set<Character> duplicateChecker = new HashSet<>();
        for (char digit : digits) {
            duplicateChecker.add(digit);
        }
        if (duplicateChecker.size() != digits.length) {
            throw new IllegalArgumentException("숫자간 중복된 입력은 허용하지 않습니다");
        }
    }

    private int convertCharToInt(char c) {
        if ('9' >= c && c >= '0') {
            return Character.getNumericValue(c);
        }
        throw new IllegalArgumentException("0~9 사이의 숫자를 입력해주세요");
    }

    public int getFirstDigit() {
        return firstDigit;
    }

    public int getSecondDigit() {
        return secondDigit;
    }

    public int getThirdDigit() {
        return thirdDigit;
    }
}
