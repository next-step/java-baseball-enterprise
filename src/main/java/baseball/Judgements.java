package baseball;

import java.io.PrintStream;
import java.util.Objects;

public class Judgements {

    private final int strike;
    private final int ball;

    public Judgements(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isThreeStrike() {
        return strike == 3 && ball == 0;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Judgements judgements = (Judgements) o;
        return strike == judgements.strike && ball == judgements.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
