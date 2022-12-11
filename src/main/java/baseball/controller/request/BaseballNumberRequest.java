package baseball.controller.request;

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
        this.firstDigit = convertCharToInt(digits[0]);
        this.secondDigit = convertCharToInt(digits[1]);
        this.thirdDigit = convertCharToInt(digits[2]);
    }

    private void validateUserInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
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
