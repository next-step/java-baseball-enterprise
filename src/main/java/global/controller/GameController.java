package global.controller;

import global.exceptions.GameException;
import global.model.Game;

public class GameController {

    private final Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void playGame() {
        try {
            game.start();
        } catch (GameException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean checkRetry() {

        return game.checkRetry();
    }

    public void finishGame() {
        game.finish();
    }
}
