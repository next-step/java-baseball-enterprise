public class MatchResult {
    private int strike, ball;

    public MatchResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isCorrect() {
        return strike == 3;
    }

    public void printResult() {
        if (strike != 0)
            System.out.print(strike + " 스트라이크 ");
        if (ball != 0)
            System.out.print(ball + "볼");
        if (strike == 0 && ball == 0)
            System.out.print("낫싱");
        System.out.println();
    }
}
