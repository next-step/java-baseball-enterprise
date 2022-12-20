package controller;

import domain.BaseballGame;
import domain.Computer;
import domain.GameResult;
import view.Console;

public class BaseballGameController {

    private static final String RESTART_FLAG = "1";
    private static final String EXIT_FLAG = "2";

    private final Computer computer;
    private final Console console;

    public BaseballGameController() {
        computer = new Computer();
        console = new Console();
    }

    public void execute() {
        BaseballGame baseballGame = new BaseballGame(computer.generateThreeDifferentNumber());

        do {
            String userNumbers = console.getUserInputNumber();
            GameResult gameResult = baseballGame.compareNumbers(userNumbers);
            console.printMessage(gameResult.getDescription());
        } while (!baseballGame.isEnd());

        restartOrExit();
    }

    public void restartOrExit() {
        console.printEndMessage();
        String userInput = console.getUserInput();

        if (userInput.equals(EXIT_FLAG)) {
            return;
        }

        execute();
    }

}
