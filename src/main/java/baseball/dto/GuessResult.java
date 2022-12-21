package baseball.dto;

public class GuessResult {

    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public GuessResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void increaseStrike() {
        this.strike++;
    }

    public void increaseBall() {
        this.ball++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.strike > 0) {
            stringBuilder.append(this.strike);
            stringBuilder.append("스트라이크 ");
        }
        if (this.ball > 0) {
            stringBuilder.append(this.ball);
            stringBuilder.append("볼");
        }
        if (this.strike == 0 && this.ball == 0) { stringBuilder.append("낫싱"); }
        return stringBuilder.toString();
    }
}
