package baseball;

import java.util.Objects;

public class Judgement {

    private final int strike;
    private final int ball;

    public Judgement(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Judgement judgement = (Judgement) o;
        return strike == judgement.strike && ball == judgement.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
