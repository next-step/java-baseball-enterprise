package game;

import config.GlobalData;
import domain.ballnumber.BallNumber;
import domain.game.GameResult;
import domain.game.GameStatus;
import view.InputManager;
import view.OutputView;

public class NumberBaseBallGameManager {

    private NumberBaseBallGame numberBaseBallGame;
    private InputManager inputManager;
    private OutputView outputView;

    public NumberBaseBallGameManager() {
        this.numberBaseBallGame = new NumberBaseBallGame(GlobalData.BALL_NUMBER_GEN_MODE);
        this.inputManager = new InputManager();
        this.outputView = new OutputView();
    }

    public void start() {
        while(!GameResult.EXIT.equals(play())){}
    }

    public GameResult play() {
        this.numberBaseBallGame.initGame();
        while(isGamePlaying()) {
            outputView.showBallResult(numberBaseBallGame.throwBall(guessBallNumber()));
        }
        outputView.showGameFinished();
        return inputManager.inputGameResult();
    }

    public boolean isGamePlaying() {
        return GameStatus.PLAYING.equals(numberBaseBallGame.getGameStatus());
    }

    public BallNumber guessBallNumber() {
        return inputManager.inputGuessedBallNumber();
    }

}
