package number_baseball.model;

import global.model.Game;
import number_baseball.strategy.ComputerPlayStrategy;
import number_baseball.view.GameView;

public class NumberBaseball extends Game {

    private final GameView gameView = new GameView();

    @Override
    public void start() {
        Rival rival = new Rival(new ComputerPlayStrategy());

        boolean success = false;
        while (!success) {
            InputAnswer input = gameView.getAnswerFromPlayer();
            GameResult result = rival.verifyAnswer(input);
            result.printResult();
            success = result.isFinished();
        }

        gameView.successGame();
    }

    @Override
    public boolean checkRetry() {
        int opt = gameView.askRetryGame();

        return opt == 1;
    }

    @Override
    public void finish() {
    }
}
