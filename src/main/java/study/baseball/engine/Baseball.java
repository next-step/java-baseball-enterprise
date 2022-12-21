package study.baseball.engine;

import study.baseball.Console;
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
        try {
            proceedGame();
        } catch (RuntimeException exception) {
            console.printError(exception.getMessage());
        }
    }

    private void proceedGame() {
        String input = console.input("숫자를 입력해주세요 : ");
        validator.checkValidFormat(input);
        Numbers answer = numberGenerator.generateRandomNumber();
    }
}
