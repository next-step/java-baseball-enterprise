package num3baseball.dataobject;

import num3baseball.exception.WrongNumberException;

public class TrialResult {
    private int strike = 0;
    private int ball = 0;
    private final int size;

    public TrialResult(int size){
        this.size = size;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getSize() {
        return size;
    }

    public TrialResult(int strike, int ball, int size){
        this.size = size;

        chkValidNumber(strike, ball);
        this.strike = strike;
        this.ball = ball;
    }

    private void chkValidNumber(int strike, int ball){
        if (strike<0 || ball<0){
            throw new WrongNumberException();
        }
        if (strike+ball > size || (strike==size-1 && ball==1)){
            throw new WrongNumberException();
        }
    }

    public void setStrikeBall(int strike, int ball){
        chkValidNumber(strike, ball);
        this.strike = strike;
        this.ball = ball;
    }
}
