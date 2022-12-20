public class Result {
    private int strike;
    private int ball;
    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void addStrike() {
        this.strike++;
    }

    public void addBall(int retainedSize) {
        this.ball += retainedSize - this.strike;
    }

    public String exportResultString() {
        StringBuilder sb = new StringBuilder();

        if(this.strike > 0) {
            sb.append(String.format("%d 스트라이크", this.strike));
        }
        if(this.ball > 0) {
            sb.append(String.format(" %d볼", this.ball));
        }

        return sb.toString();
    }
}
