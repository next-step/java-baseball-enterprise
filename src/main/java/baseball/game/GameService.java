package baseball.game;

import baseball.domain.computer.Computer;
import baseball.domain.user.UserInput;
import baseball.util.constant.BaseballMessageConstant;

import java.util.Scanner;

import static baseball.util.constant.BaseballMessageConstant.*;
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
            printMessage(resultString + "\n");
            quit = isQuit(scanner, resultString);
        }
    }

    private boolean isQuit(Scanner scanner, String resultString) {
        if(resultString.equals("3 스트라이크")) {
            init();
            printMessage(QUESTION_GAME_END);
            return validate(Integer.parseInt(scanner.nextLine()));
        }
        return false;
    }

    private String getUserInputFromUser(Scanner scanner) {
        printMessage(REQUEST_USER_INPUT);
        return scanner.nextLine();
    }

    private void printMessage(String message) {
        System.out.print(message);
    }

    private void init() {
        this.computer = new Computer();
    }
}
