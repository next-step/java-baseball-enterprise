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
}
