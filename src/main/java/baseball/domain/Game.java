package baseball.domain;

import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.util.validator.UserInputValidator;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Computer computer;
    private Result result;
    private UserInputValidator validator;

    public void Start() {
        initializeProps();
        boolean isEnd = false;
        while(!isEnd) {
            Scanner scanner = new Scanner(System.in);
            String resultString = getResult(scanner);
            System.out.println(resultString);
            isEnd = determineEndGame(scanner, resultString);
        }
    }

    private String getResult(Scanner scanner) {
        return computer.calculateResult(getIntegerListFromInput(validator.validateInput(getInputFromUser(scanner))))
                .exportResultString();
    }

    private Boolean determineEndGame(Scanner scanner, String resultString) {
        if(resultString.equals("3 스트라이크")) {
            initializeProps();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return validator.validateEndInputFromUser(scanner.nextLine());
        }
        return false;
    }

    private List<Integer> getIntegerListFromInput(int input) {
        List<Integer> result = new ArrayList<>();
        while(input > 0) {
            result.add(input % 10);
            input /= 10;
        }
        Collections.reverse(result);
        return result;
    }

    private String getInputFromUser(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    private void initializeProps() {
        this.computer = new Computer();
        this.result = new Result(0, 0);
        this.validator = new UserInputValidator();
    }
}
