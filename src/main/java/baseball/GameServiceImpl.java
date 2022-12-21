package baseball;

import baseball.IO.InputHandler;
import baseball.IO.OutputPrinter;
import baseball.dto.GuessResult;
import baseball.enumeration.GameEndOption;
import baseball.model.Game;

import java.util.Random;

public class GameServiceImpl implements GameService {

    private final InputHandler inputHandler;
    private final OutputPrinter outputPrinter;

    public GameServiceImpl(InputHandler inputHandler, OutputPrinter outputPrinter) {
        this.inputHandler = inputHandler;
        this.outputPrinter = outputPrinter;
    }

    @Override
    public void startService() {
        GameEndOption gameEndOption;
        do {
            runGame();
            gameEndOption = endGame();
        } while (gameEndOption == GameEndOption.RESTART);
    }

    public void runGame() {
        Game game = generateRandomAnswer();
        while (!game.isCleared()) {
            outputPrinter.printInputGuideMessage();
            int input = inputHandler.getInput();
            validateGuess(input);
            GuessResult guessResult = game.check(input);
            outputPrinter.printResult(guessResult);
        }
    }

    public GameEndOption endGame() {
        outputPrinter.printClearMessage();
        int input = inputHandler.getInput();
        if (input == 1) {
            return GameEndOption.RESTART;
        }
        if (input == 2) {
            return GameEndOption.EXIT;
        }
        throw new Error("입력값이 올바르지 않습니다.");
    }

    public void validateGuess(int input) {
        if (input < 100 || input >= 1000) {
            throw new Error("입력값이 올바르지 않습니다.");
        }
    }



    @Override
    public Game generateRandomAnswer() {
        Random random = new Random();
        int x = random.nextInt(9) + 1;
        int y; int z;
        do {
            y = random.nextInt(9) + 1;
        } while (x == y);
        do {
            z = random.nextInt(9) + 1;
        } while (x == z || y == z);
        return new Game(new int[]{x, y, z});
    }
}
