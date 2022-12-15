package numberbaseball;

import numberbaseballimpl.BaseImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseTest {


    @Test
    void createRandomBase_valid_while_100_Times() {
        boolean result = true;
        for (int i = 0; i < 100; ++i) {
            Base base = BaseImpl.createRandomBase();
            result &= isValid(base);
        }
        assertTrue(result);
    }

    private static boolean isValid(Base base) {
        boolean result = true;
        Set<Integer> numbers = new HashSet<>();
        for (int number : base.getNumbers()) {
            result &= isValidNumber(numbers, number);
        }
        return result;
    }

    private static boolean isValidNumber(Set<Integer> numberSet, int number) {
        if (!isInRange(number) || numberSet.contains(number))
            return false;
        numberSet.add(number);
        return true;
    }

    private static boolean isInRange(int number) {
        return number >= 0 && number <= 9;
    }

    @Test
    void isStrike_true_givenSameNumber() {
        Base base = BaseImpl.createRandomBase();
        int[] numbers = base.getNumbers();

        boolean isStrike = base.isStrike(0, numbers[0]);

        assertTrue(isStrike);
    }

    @Test
    void isStrike_false_givenDiffNumber() {
        Base base = BaseImpl.createRandomBase();
        int[] numbers = base.getNumbers();

        boolean isStrike = base.isStrike(0, numbers[1]);

        assertFalse(isStrike);
    }

    @Test
    void isBall_true_givenDiffNumber() {
        Base base = BaseImpl.createRandomBase();
        int[] numbers = base.getNumbers();

        boolean isBall = base.isBall(0, numbers[1]);

        assertTrue(isBall);
    }

    @Test
    void isBall_false_givenSameNumber() {
        Base base = BaseImpl.createRandomBase();
        int[] numbers = base.getNumbers();

        boolean isBall = base.isBall(0, numbers[0]);

        assertFalse(isBall);
    }

    @Test
    void isBall_false_givenWrongNumber() {
        Base base = BaseImpl.createRandomBase();

        boolean isBall = base.isBall(0, 0);

        assertFalse(isBall);
    }
}