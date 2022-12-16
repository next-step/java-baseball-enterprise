package numberbaseball;

import numberbaseballimpl.HintImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HintTest {

    @Mock
    private Base base;

    @Mock
    private Ball ball;

    @Test
    void create_throwException_whenBaseIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            HintImpl.create(null, ball);
        });
    }

    @Test
    void create_throwException_whenBallIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            HintImpl.create(base, null);
        });
    }

    @Test
    void getStrike_willReturn0_whenNothing() {
        int[] numbers = {1, 2, 3};
        when(ball.getNumbers()).thenReturn(numbers);
        Hint hint = HintImpl.create(base, ball);
        assertEquals(0, hint.getStrike());
    }

    @Test
    void getStrike_willReturn1_when1Strike() {
        int[] numbers = {1, 2, 3};
        when(ball.getNumbers()).thenReturn(numbers);
        when(base.isStrike(0, 1)).thenReturn(true);
        Hint hint = HintImpl.create(base, ball);
        assertEquals(1, hint.getStrike());
    }

    @Test
    void getBall_willReturn0_whenNothing() {
        int[] numbers = {1, 2, 3};
        when(ball.getNumbers()).thenReturn(numbers);
        Hint hint = HintImpl.create(base, ball);
        assertEquals(0, hint.getBall());
    }

    @Test
    void getBall_willReturn1_when1Ball() {
        int[] numbers = {1, 2, 3};
        when(ball.getNumbers()).thenReturn(numbers);
        when(base.isBall(0, 1)).thenReturn(true);
        Hint hint = HintImpl.create(base, ball);
        assertEquals(1, hint.getBall());
    }

    @Test
    void getBall_willReturn3_when3Ball() {
        int[] numbers = {1, 2, 3};
        when(ball.getNumbers()).thenReturn(numbers);
        when(base.isBall(0, 1)).thenReturn(true);
        when(base.isBall(1, 2)).thenReturn(true);
        when(base.isBall(2, 3)).thenReturn(true);
        Hint hint = HintImpl.create(base, ball);
        assertEquals(3, hint.getBall());
    }

    @Test
    void isNothing_true_whenNothing() {
        int[] numbers = {1, 2, 3};
        when(ball.getNumbers()).thenReturn(numbers);
        Hint hint = HintImpl.create(base, ball);
        assertTrue(hint.isNothing());
    }

    @Test
    void isNothing_false_when1Strike() {
        int[] numbers = {1, 2, 3};
        when(ball.getNumbers()).thenReturn(numbers);
        when(base.isStrike(0, numbers[0])).thenReturn(true);
        Hint hint = HintImpl.create(base, ball);
        assertFalse(hint.isNothing());
    }

    @Test
    void isAnswer_true_whenBaseEqualsBall() {
        int[] numbers = {1, 2, 3};
        when(ball.getNumbers()).thenReturn(numbers);
        for (int i = 0; i < 3; ++i) {
            when(base.isStrike(i, numbers[i])).thenReturn(true);
        }
        Hint hint = HintImpl.create(base, ball);
        assertTrue(hint.isAnswer());
    }

    @Test
    void isAnswer_false_when2Strike() {
        int[] numbers = {1, 2, 3};
        when(ball.getNumbers()).thenReturn(numbers);
        for (int i = 0; i < 2; ++i) {
            when(base.isStrike(i, numbers[i])).thenReturn(true);
        }
        Hint hint = HintImpl.create(base, ball);
        assertFalse(hint.isAnswer());
    }
}