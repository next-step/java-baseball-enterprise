package baseball;

import baseball.controller.GameController;
import baseball.model.Game;
import baseball.model.domain.RandomBaseballNumberGenerator;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(RandomBaseballNumberGenerator.create());
        GameController gameController = new GameController(game);
        GameView gameView = new GameView(gameController);
        gameView.playGame();
    }
}
