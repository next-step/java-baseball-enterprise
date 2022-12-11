package baseball.controller;

import baseball.controller.request.BaseballNumberRequest;
import baseball.controller.response.GameResponse;
import baseball.model.Game;

public class GameController {

    private final Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public GameResponse compareBaseballNumberRequest(BaseballNumberRequest baseballNumberRequest) {
        return game.compare(baseballNumberRequest);
    }

    public boolean isGamePlaying() {
        return game.isPlaying();
    }

    public void restartGame() {
        game.restart();
    }
}
