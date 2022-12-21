package study.baseball.engine;

import java.util.List;
import study.baseball.Console;
import study.baseball.engine.model.BallCount;
import study.baseball.engine.model.Numbers;

public class Baseball implements Runnable {
    private final Console console;
    private final InputValidator validator;
    private final InputParser parser;
    private final NumberGenerator numberGenerator;

    public Baseball(Console console, InputValidator inputValidator, InputParser inputParser,
                    NumberGenerator numberGenerator) {
        this.console = console;
        this.validator = inputValidator;
        this.parser = inputParser;
        this.numberGenerator = numberGenerator;
    }

    @Override
    public void run() {
        while (true) {
            Numbers answer = numberGenerator.generateRandomNumber();
            while (saveGame(answer))
                ;
            if (askContinue()) {
                continue;
            }
            break;
        }
    }

    private boolean saveGame(Numbers answer) {
        try {
            return proceedGame(answer);
        } catch (RuntimeException exception) {
            console.printError(exception.getMessage());
            return true;
        }
    }

    private boolean proceedGame(Numbers answer) {
        String input = console.input("숫자를 입력해주세요 : ");
        validator.checkValidFormat(input);
        List<Integer> parsedInput = parser.parseStringToIntegerList(input);
        BallCount result = new BallCount(answer.getStrike(parsedInput), answer.getBall(parsedInput));
        if (result.getStrike() == 3) {
            console.printOutput("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        showResult(result);
        return true;
    }

    private boolean askContinue() {
        while (true) {
            String input = console.input("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            if (input.equals("1")) {
                return true;
            }
            if (input.equals("2")) {
                return false;
            }
            console.printError("잘못된 입력입니다.");
        }
    }

    private void showResult(BallCount ballCount) {
        StringBuilder output = new StringBuilder();
        if (ballCount.getStrike() > 0) {
            output.append(ballCount.getStrike()).append(" 스트라이크 ");
        }
        if (ballCount.getBall() > 0) {
            output.append(ballCount.getBall()).append(" 볼 ");
        }
        console.printOutput(output.toString().length() > 0 ? output.toString() : "낫싱");
    }
}
