package numberbaseballimpl;

import numberbaseball.Ball;
import numberbaseball.Base;
import numberbaseball.Hint;
import numberbaseball.Enemy;

public class EnemyImpl implements Enemy {

    private Base base;

    public static Enemy from(Base base) {
        return new EnemyImpl(base);
    }

    private EnemyImpl(Base base) {
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
