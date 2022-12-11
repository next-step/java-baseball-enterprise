package baseball.controller;

import baseball.controller.request.BaseballNumberRequest;
import baseball.controller.response.GameResponse;
import baseball.model.Game;

public class GameController {

    private final Game game;

    public GameController() {
        this.game = new Game();
    }

    public GameResponse compareBaseballNumberRequest(BaseballNumberRequest baseballNumberRequest) {
        return game.compare(baseballNumberRequest);
    }

    public void restartGame() {
        game.restart();
    }
}
