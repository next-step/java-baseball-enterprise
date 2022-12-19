import global.controller.GameController;
import number_baseball.model.NumberBaseball;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new NumberBaseball());

        boolean retry = true;
        while (retry) {
            gameController.playGame();
            retry = gameController.checkRetry();
        }

        gameController.finishGame();
    }
}
