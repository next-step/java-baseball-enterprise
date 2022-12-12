package baseball.model.domain;

import java.util.List;

public class StrikeBallResult {

    private final int strike;
    private final int ball;

    public StrikeBallResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static StrikeBallResult of(int strike, int ball) {
        return new StrikeBallResult(strike, ball);
    }

    public static StrikeBallResult addAll(List<StrikeBallResult> strikeBallResults) {
        int strike = 0;
        int ball = 0;
        for (StrikeBallResult strikeBallResult : strikeBallResults) {
            strike += strikeBallResult.strike;
            ball += strikeBallResult.ball;
        }
        return new StrikeBallResult(strike, ball);
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
