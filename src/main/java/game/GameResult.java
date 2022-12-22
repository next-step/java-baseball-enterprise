package game;

public class GameResult {
    public int ball;
    public int strike;

    GameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isNothing() {
        return this.strike == 0 && this.ball == 0;
    }

    public boolean isAllStrike() {
        return this.strike == 3 && this.ball == 0;
    }

    @Override
    public String toString() {
        if (this.isNothing()) {
            return "nothing";
        }
        if (this.isAllStrike()) {
            return "all strike";
        }
        return String.format("%d strike, %d ball", this.strike, this.ball);
    }
}
