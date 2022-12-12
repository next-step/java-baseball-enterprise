package baseball.controller.request;

public class RestartRequest {

    private final boolean restart;

    public RestartRequest(boolean restart) {
        this.restart = restart;
    }

    public static RestartRequest of(String userInput) {
        int restartNumber;
        try {
            restartNumber = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return generateRestartRequest(restartNumber);
    }

    private static RestartRequest generateRestartRequest(int restartNumber) {
        if (restartNumber == 1) {
            return new RestartRequest(true);
        }
        if (restartNumber == 2) {
            return new RestartRequest(false);
        }
        throw new IllegalArgumentException("1 혹은 2 만 입력 가능합니다.");
    }

    public boolean isRestart() {
        return restart;
    }
}
