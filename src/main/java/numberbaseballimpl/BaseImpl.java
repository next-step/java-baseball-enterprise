package numberbaseballimpl;

import numberbaseball.Base;

import java.util.*;

public class BaseImpl implements Base {

    public static final int NUMBERS_SIZE = 3;
    private final Integer[] numbers;
    private final Set<Integer> numberSet;

    private BaseImpl() {
        List<Integer> randomNumbers = getRandomNumbers();
        numbers = randomNumbers.toArray(Integer[]::new);
        numberSet = new HashSet<>(randomNumbers);
    }

    private static List<Integer> getRandomNumbers() {
        Integer[] baseNumbers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> numbersWrapper = new ArrayList<>(List.of(baseNumbers));
        Collections.shuffle(numbersWrapper);
        return numbersWrapper.subList(0, NUMBERS_SIZE);
    }

    public static Base createRandomBase() {
        return new BaseImpl();
    }

    @Override
    public int[] getNumbers() {
        int[] numbers = new int[NUMBERS_SIZE];
        for (int i = 0; i < NUMBERS_SIZE; ++i) {
            numbers[i] = this.numbers[i];
        }
        return numbers;
    }

    @Override
    public boolean isStrike(int index, int number) {
        return numbers[index] == number;
    }

    @Override
    public boolean isBall(int index, int number) {
        return numbers[index] != number && numberSet.contains(number);
    }
}
