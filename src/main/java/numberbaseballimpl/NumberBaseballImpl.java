package numberbaseballimpl;

import numberbaseball.Ball;
import numberbaseball.Base;
import numberbaseball.Hint;
import numberbaseball.NumberBaseball;

public class NumberBaseballImpl implements NumberBaseball {

    private NumberBaseballImpl(Base base) {
    }

    public static NumberBaseball from(Base base) {
        return new NumberBaseballImpl(base);
    }

    @Override
    public void reset(Base base) {

    }

    @Override
    public Hint shoot(Ball ball) {
        return null;
    }
}
