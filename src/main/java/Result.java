public class Result {
    private int strike = 0;
    private int ball = 0;

    public void addStrike() {
        this.strike++;
    }

    public void addBall(int retainedSize) {
        this.ball += retainedSize - strike;
    }
}
