package domain.ballnumber;

import config.GlobalData;

import java.util.HashSet;
import java.util.Set;

public class BallResult {

    private int strike;
    private int ball;

    public BallResult() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public static BallResult createBallResult(BallNumber correctBallNumber, BallNumber guessedBallNumber) {
        BallResult ballResult = new BallResult();
        Set correctBallNumberSet = new HashSet(correctBallNumber.getDigits());
        for(int i=0; i<guessedBallNumber.getLength(); i++) {
            int numberToCheck = guessedBallNumber.getDigits().get(i);
            ballResult.countStrikeBall(correctBallNumberSet.contains(numberToCheck),
                    correctBallNumber.getDigits().get(i)==numberToCheck);
        }
        return ballResult;
    }

    public void countStrikeBall(boolean isContained, boolean isDigitSame) {
        if(isDigitSame) {
            this.strike++;
            return;
        }
        if(isContained) {
            this.ball++;
        }
    }

    public boolean isAllStrike() {
        return strike== GlobalData.BALL_NUMBER_LENGTH;
    }

}
