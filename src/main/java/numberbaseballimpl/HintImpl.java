package numberbaseballimpl;

import numberbaseball.*;

public class HintImpl implements Hint {

    private HintImpl() {

    }

    public static Hint create(Base base, Ball ball) {
        return new HintImpl();
    }

    @Override
    public int getStrike() {
        return 0;
    }

    @Override
    public int getBall() {
        return 0;
    }

    @Override
    public boolean isNothing() {
        return false;
    }

    @Override
    public boolean isAnswer() {
        return false;
    }
}
