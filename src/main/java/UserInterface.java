import java.util.Scanner;

public class UserInterface {
    private String parseUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private boolean isValidNumberInput(String userInput) {
        String REGEX = "\\d{3}";
        return userInput.matches(REGEX);
    }

    public String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = parseUserInput();

        if (!isValidNumberInput(userInput)) {
            System.out.println("세 자리의 숫자만 입력해주세요.");
            return getUserInput();
        }
        return userInput;
    }

    private String getStrikeBallString(int strikes, int balls) {
        StringBuilder result = new StringBuilder();
        if (strikes > 0) {
            result.append(strikes).append(' ').append("스트라이크").append(' ');
        }
        if (balls > 0) {
            result.append(balls).append(' ').append("볼");
        }
        return result.toString();
    }

    public void printResult(JudgementResult judgementResult) {
        if (judgementResult.strikes == 0 && judgementResult.balls == 0) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(getStrikeBallString(judgementResult.strikes, judgementResult.balls));
    }

    public void printGameFinished() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean isValidRestartInput(String userInput) {
        if (userInput.length() != 1) {
            return false;
        }
        if (userInput.charAt(0) != '1' && userInput.charAt(0) != '2') {
            return false;
        }
        return true;
    }

    public boolean isRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = parseUserInput();
        if (!isValidRestartInput(userInput)) {
            System.out.println("1 또는 2만 입력해주세요.");
            return isRestartGame();
        }
        return userInput.charAt(0) == '1';
    }

    public void printExit() {
        System.out.println("게임을 종료합니다.");
    }
}
