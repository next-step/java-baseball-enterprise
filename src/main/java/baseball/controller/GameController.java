package baseball.controller;

import baseball.BaseballNumbersGenerator;
import baseball.domain.BaseballGame;
import baseball.domain.StrikeBallCount;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballNumbersGenerator baseballNumbersGenerator;
    private BaseballGame baseballGame;
    private StrikeBallCount strikeBallCount;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        baseballNumbersGenerator = new BaseballNumbersGenerator();
    }

    public void play() {
        do {
            initializeGame();
            playGame();
        } while (inputView.readInputRestart());
    }

    private void initializeGame() {
        baseballGame = new BaseballGame(baseballNumbersGenerator.generate());
    }

    private void playGame() {
        do {
            strikeBallCount = baseballGame.getResult(inputView.readInputUserAnswer());
            printResult();
        } while (!strikeBallCount.getIsComplete());
    }

    private void printResult() {
        outputView.printResult(strikeBallCount);
    }
}
