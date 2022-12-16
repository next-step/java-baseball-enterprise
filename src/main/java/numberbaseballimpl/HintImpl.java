package numberbaseballimpl;

import numberbaseball.*;

public class HintImpl implements Hint {

    public static final int NUMBERS_SIZE = 3;
    private int strike = 0;
    private int ball = 0;

    private HintImpl(Base base, Ball ball) {
        int[] numbers = ball.getNumbers();
        for (int i = 0; i < NUMBERS_SIZE; ++i) {
            increaseHint(base, i, numbers[i]);
        }
    }

    private void increaseHint(Base base, int index, int number) {
        if (base.isStrike(index, number)) {
            ++strike;
        }
        if (base.isBall(index, number)) {
            ++ball;
        }
    }

    public static Hint create(Base base, Ball ball) {
        if (base == null || ball == null)
            throw new IllegalArgumentException("Base or ball must be not null.");
        return new HintImpl(base, ball);
    }

    @Override
    public int getStrike() {
        return strike;
    }

    @Override
    public int getBall() {
        return ball;
    }

    @Override
    public boolean isNothing() {
        return strike + ball == 0;
    }

    @Override
    public boolean isAnswer() {
        return strike == NUMBERS_SIZE;
    }
}
