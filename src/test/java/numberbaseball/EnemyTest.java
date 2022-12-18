package numberbaseball;

import numberbaseballimpl.BallImpl;
import numberbaseballimpl.BaseImpl;
import numberbaseballimpl.EnemyImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EnemyTest {

    @Test
    void from_throwException_baseIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            EnemyImpl.from(null);
        });
    }

    @Test
    void reset_throwException_baseIsNull() {
        Base base = BaseImpl.createRandomBase();
        Enemy enemy = EnemyImpl.from(base);
        assertThrows(IllegalArgumentException.class, () -> {
            enemy.reset(null);
        });
    }

    @Test
    void shoot_throwException_ballIsNull() {
        Base base = BaseImpl.createRandomBase();
        Enemy enemy = EnemyImpl.from(base);
        assertThrows(IllegalArgumentException.class, () -> {
            enemy.shoot(null);
        });
    }

    @Test
    void shoot_willReturnAnswerHint_ballEqualsBase() {
        Base base = BaseImpl.createRandomBase();
        Ball ball = baseToBall(base);
        Enemy enemy = EnemyImpl.from(base);
        Hint hint = enemy.shoot(ball);
        assertTrue(hint.isAnswer());
    }

    private static Ball baseToBall(Base base) {
        int[] numbers = base.getNumbers();
        int sum = 0;
        for (int number : numbers) {
            sum = sum * 10 + number;
        }
        return BallImpl.from(sum);
    }
}