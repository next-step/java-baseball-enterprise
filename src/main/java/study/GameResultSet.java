package study;

import java.util.Objects;

public class GameResultSet {
    public int strike;
    public int ball;

    public GameResultSet() {
        this.strike = 0;
        this.ball = 0;
    }

    public GameResultSet(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResultSet that = (GameResultSet) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public String toString() {
        return "GameResultSet{" +
                "strike=" + strike +
                ", ball=" + ball +
                '}';
    }
}
