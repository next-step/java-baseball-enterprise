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
