package baseball;

import baseball.domain.computer.Computer;
import baseball.domain.user.UserInput;

import java.util.Scanner;

import static baseball.util.validator.UserInputValidator.*;

public class GameService {
    private Computer computer;

    public GameService() {
        init();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while(!quit) {
            String resultString = computer.calculateResult(new UserInput(getUserInputFromUser(scanner)))
                    .exportResultString();
            System.out.println(resultString);
            quit = isQuit(scanner, resultString);
        }
    }

    private boolean isQuit(Scanner scanner, String resultString) {
        if(resultString.equals("3 스트라이크")) {
            init();
            printGameEndQuestion();
            return validateAndIsTwo(scanner.nextInt());
        }
        return false;
    }

    private void printGameEndQuestion() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private String getUserInputFromUser(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    private void init() {
        this.computer = new Computer();
    }
}
