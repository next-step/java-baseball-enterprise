package numberbaseballimpl;

import numberbaseball.Ball;

import java.util.HashSet;
import java.util.Set;

public class BallImpl implements Ball {

    public static final int NUMBERS_SIZE = 3;
    private final int[] numbers;

    private BallImpl(int[] numbers) {
        this.numbers = numbers;
    }

    public static Ball from(int number) {
        int[] numbers = intToNumbers(number);
        return new BallImpl(numbers);
    }

    private static int[] intToNumbers(int number) {
        checkNumberLength(number);
        int[] numbers = new int[NUMBERS_SIZE];
        Set<Integer> numberSet = new HashSet<>();
        for (int i = NUMBERS_SIZE - 1; i >= 0; --i) {
            numbers[i] = number % 10;
            checkDigitValidation(numberSet, numbers[i]);
            number /= 10;
        }
        return numbers;
    }

    private static void checkNumberLength(int number) {
        if (isTooShortNumber(number))
            throw new IllegalArgumentException("Number is too short.");
        if (isTooLongNumber(number))
            throw new IllegalArgumentException("Number is too long.");
    }

    private static boolean isTooShortNumber(int number) {
        return number <= (int) Math.pow(10, NUMBERS_SIZE - 1);
    }

    private static boolean isTooLongNumber(int number) {
        return number >= (int) Math.pow(10, NUMBERS_SIZE);
    }

    private static void checkDigitValidation(Set<Integer> numberSet, int digit) {
        checkDuplication(numberSet, digit);
        checkZero(digit);
        numberSet.add(digit);
    }

    private static void checkDuplication(Set<Integer> numberSet, int digit) {
        if (numberSet.contains(digit))
            throw new IllegalArgumentException("Number must not duplicate.");
    }

    private static void checkZero(int digit) {
        if (digit == 0)
            throw new IllegalArgumentException("Number must haven't zero.");
    }

    @Override
    public int[] getNumbers() {
        return numbers.clone();
    }
}
