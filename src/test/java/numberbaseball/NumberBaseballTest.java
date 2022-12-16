package numberbaseball;

import numberbaseballimpl.BallImpl;
import numberbaseballimpl.BaseImpl;
import numberbaseballimpl.NumberBaseballImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberBaseballTest {

    @Test
    void from_throwException_baseIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            NumberBaseballImpl.from(null);
        });
    }

    @Test
    void reset_throwException_baseIsNull() {
        Base base = BaseImpl.createRandomBase();
        NumberBaseball numberBaseball = NumberBaseballImpl.from(base);
        assertThrows(IllegalArgumentException.class, () -> {
            numberBaseball.reset(null);
        });
    }

    @Test
    void shoot_throwException_ballIsNull() {
        Base base = BaseImpl.createRandomBase();
        NumberBaseball numberBaseball = NumberBaseballImpl.from(base);
        assertThrows(IllegalArgumentException.class, () -> {
            numberBaseball.shoot(null);
        });
    }

    @Test
    void shoot_willReturnAnswerHint_ballEqualsBase() {
        Base base = BaseImpl.createRandomBase();
        Ball ball = baseToBall(base);
        NumberBaseball numberBaseball = NumberBaseballImpl.from(base);
        Hint hint = numberBaseball.shoot(ball);
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