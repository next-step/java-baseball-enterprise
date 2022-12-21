package baseball.domain;

import baseball.util.validator.UserInputValidator;
import java.util.Scanner;

import static baseball.util.constant.NumberConstant.*;
import static baseball.util.util.NumberUtils.*;

public class Game {
    private Computer computer;
    private UserInputValidator validator;

    public Game() {
        init();
    }

    public void start() {
        boolean quit = false;
        while(!quit) {
            Scanner scanner = new Scanner(System.in);
            String result = getResult(validator.validateInputAndReturn(getInputFromUser(scanner)));
            System.out.println(result);
            quit = isEnd(result, scanner);
        }
    }

    private boolean isEnd(String result, Scanner scanner) {
        if(result.equals("3 스트라이크")) {
            init();
            printGameEndQuestion();
            return validator.validateInputAndReturn(scanner.nextLine(), new NumberRange(1, 2)) == 2;
        }
        return false;
    }

    private String getResult(int input) {
        return computer.calculateResult(getSingleIntegerListFromInt(input))
                .exportResultString();
    }

    private void printGameEndQuestion() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private String getInputFromUser(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    private void init() {
        this.computer = new Computer();
        this.validator = new UserInputValidator(new NumberRange(INPUT_MIN, INPUT_MAX));
    }
}
