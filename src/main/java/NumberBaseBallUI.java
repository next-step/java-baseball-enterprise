import java.util.Scanner;

public class NumberBaseBallUI {

    private final Scanner sc = new Scanner(System.in);

    public String getUserGuess() {
        return getInput("숫자를 입력해주세요: ");
    }

    public String getEndOption() {
        return getInput("끝내려면 1, 재시작하려면 2를 입력해주세요: ");
    }

    private String getInput(String message) {
        System.out.println(message);
        return sc.next();
    }

    public void displayResult(int strikes, int balls) {
        StringBuilder message = new StringBuilder();
        if (strikes == 0 && balls == 0) {
            message.append("낫싱");
        }
        if (strikes > 0) {
            message.append(strikes).append(" 스트라이크 ");
        }
        if (balls > 0) {
            message.append(balls).append(" 볼");
        }
        System.out.println(message);
    }
}
