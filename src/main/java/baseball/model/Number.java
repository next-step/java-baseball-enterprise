package baseball.model;

import java.util.Objects;

public class Number {

    private final char value;
    private final int index;

    public Number(char value, int index) {
        this.value = value;
        this.index = index;
    }

    public Judgement judge(Number other) {
        if (isBall(other)) {
            return Judgement.BALL;
        }

        if (isStrike(other)) {
            return Judgement.STRIKE;
        }

        return Judgement.NOTHING;
    }

    private boolean isBall(Number number) {
        return value == number.value && index != number.index;
    }

    private boolean isStrike(Number number) {
        return value == number.value && index == number.index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return value == number.value && index == number.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, index);
    }
}
