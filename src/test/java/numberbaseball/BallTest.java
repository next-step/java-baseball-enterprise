package numberbaseball;

import numberbaseballimpl.BallImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    void from_throwException_givenShortNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            BallImpl.from(12);
        });
    }

    @Test
    void from_throwException_givenLongNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            BallImpl.from(1234);
        });
    }

    @Test
    void from_throwException_givenZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            BallImpl.from(120);
        });
    }

    @Test
    void from_throwException_givenDuplicatedNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            BallImpl.from(111);
        });
    }


    @Test
    void from_success_whenInRange() {
        Ball ball = BallImpl.from(123);
        int[] numbers = ball.getNumbers();
        assertEquals(3, numbers[2]);
    }
}