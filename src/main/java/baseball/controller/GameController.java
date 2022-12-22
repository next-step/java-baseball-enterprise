package baseball.controller;

import baseball.BaseballNumbersGenerator;
import baseball.constant.Constant;
import baseball.domain.BaseballGame;
import baseball.domain.StrikeBallCount;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static final String END_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String END_MESSAGE = String.format(END_FORMAT, Constant.LENGTH.getValue());
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
            System.out.println(END_MESSAGE);
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
