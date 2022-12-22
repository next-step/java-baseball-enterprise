package global.controller;

import global.controller.GameController;
import global.exception.GameException;

public final class GameRunner {
    private GameController gameController;

    public GameRunner(GameController gameController) {
        this.gameController = gameController;
    }

    public void run() {
        try {
            runGameLifeCycle();
        } catch(GameException e) {
            System.out.println(e.getMessage());
        }
    }

    private void runGameLifeCycle() {
        gameController.run();
        while(gameController.isWillingToReplayingGame()) {
            gameController.run();
        }
        gameController.quitGame();
    }

}
