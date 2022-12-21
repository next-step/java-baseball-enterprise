package baseball;

import baseball.IO.InputHandler;
import baseball.IO.SystemInputHandler;
import baseball.IO.SystemOutputPrinter;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new SystemInputHandler();
        SystemOutputPrinter outputPrinter = new SystemOutputPrinter();
        GameService gameService = new GameServiceImpl(inputHandler, outputPrinter);
        gameService.startService();
    }
}
