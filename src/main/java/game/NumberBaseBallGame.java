package game;

import config.GlobalData;
import domain.ballnumber.BallNumber;
import domain.ballnumber.BallResult;
import domain.ballnumber.generator.BallNumberGenMode;
import domain.ballnumber.generator.BallNumberGenerator;
import domain.ballnumber.generator.RandomBallNumberGenerator;
import domain.game.GameStatus;

public class NumberBaseBallGame {

    private GameStatus gameStatus;
    private BallNumberGenerator ballNumberGenerator;
    private BallNumber correctBallNumber;

    private NumberBaseBallGame() {
        this.gameStatus = GameStatus.READY;
    }

    public NumberBaseBallGame(BallNumberGenMode mode) {
        this();
        if (BallNumberGenMode.RANDOM.equals(mode))
            this.ballNumberGenerator = new RandomBallNumberGenerator();
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public BallNumber getCorrectBallNumber() {
        return this.correctBallNumber;
    }

    public void initGame() {
        generateBallNumber();
        this.gameStatus = GameStatus.PLAYING;
    }

    public void generateBallNumber() {
        if(this.ballNumberGenerator==null) return;
        this.correctBallNumber = this.ballNumberGenerator.generate(GlobalData.BALL_NUMBER_LENGTH);
    }

    public BallResult throwBall(BallNumber guessedBallNumber) {
        BallResult ballResult = compareBallNumber(guessedBallNumber);
        if(ballResult.isAllStrike()) this.gameStatus = GameStatus.FINISH;
        return ballResult;
    }

    public BallResult compareBallNumber(BallNumber guessedBallNumber) {
        return BallResult.createBallResult(this.correctBallNumber, guessedBallNumber);
    }

}
