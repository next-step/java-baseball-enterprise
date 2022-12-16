package numberbaseballimpl;

import numberbaseball.Ball;
import numberbaseball.Base;
import numberbaseball.Hint;
import numberbaseball.NumberBaseball;

public class NumberBaseballImpl implements NumberBaseball {

    private Base base;

    public static NumberBaseball from(Base base) {
        return new NumberBaseballImpl(base);
    }

    private NumberBaseballImpl(Base base) {
        reset(base);
    }

    @Override
    public void reset(Base base) {
        checkBaseNotNull(base);
        this.base = base;
    }

    private static void checkBaseNotNull(Base base) {
        if (base == null) {
            throw new IllegalArgumentException("Base is not null.");
        }
    }

    @Override
    public Hint shoot(Ball ball) {
        return HintImpl.create(base, ball);
    }
}
