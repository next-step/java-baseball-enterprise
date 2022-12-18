import config.GlobalData;
import domain.ballnumber.BallNumber;
import domain.ballnumber.BallResult;
import domain.ballnumber.generator.BallNumberGenMode;
import domain.ballnumber.generator.BallNumberGenerator;
import domain.ballnumber.generator.RandomBallNumberGenerator;
import domain.game.GameResult;
import domain.game.GameStatus;
import view.OutputView;

public class NumberBaseBallGame {

    private GameStatus gameStatus;
    private BallNumberGenerator ballNumberGenerator;
    private InputManager inputManager;
    private OutputView outputView;
    private BallNumber correctBallNumber;

    private NumberBaseBallGame() {
        this.gameStatus = GameStatus.PLAYING;
        this.inputManager = new InputManager();
        this.outputView = new OutputView();
    }

    public NumberBaseBallGame(BallNumberGenMode mode) {
        this();
        if(BallNumberGenMode.RANDOM.equals(mode))
            this.ballNumberGenerator = new RandomBallNumberGenerator();
        this.correctBallNumber = this.ballNumberGenerator.generate(GlobalData.BALL_NUMBER_LENGTH);
    }


    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public GameResult play() {
        while(GameStatus.PLAYING.equals(this.gameStatus)) {
            BallNumber guessedBallNumber = inputManager.inputGuessedBallNumber();
            BallResult ballResult = BallResult.createBallResult(correctBallNumber,guessedBallNumber);
            outputView.showBallResult(ballResult);
            checkBallResult(ballResult);
        }
        return GameResult.STOP;
    }

    public void checkBallResult(BallResult ballResult) {
        if(ballResult.isAllStrike()) this.gameStatus = GameStatus.FINISH;
    }


}
