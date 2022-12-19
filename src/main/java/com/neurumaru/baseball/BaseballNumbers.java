package com.neurumaru.baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private static final int MIN_DIGIT = 1;
    private static final int MAX_DIGIT = 9;
    private static final List<Integer> LOOK_UP_TABLE = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    private List<Integer> numbers;

    public BaseballNumbers(int digit) {
        int validDigit = cutMinMax(digit, MIN_DIGIT, MAX_DIGIT);
        setRandomNumbers(validDigit);
    }

    public BaseballNumbers(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers.size());
        this.numbers.addAll(numbers);
    }

    public BaseballNumbers(int digit, int numbers) {
        int validDigit = cutMinMax(digit, MIN_DIGIT, MAX_DIGIT);
        this.numbers = new ArrayList<>(validDigit);
        char[] characters = String.valueOf(numbers).toCharArray();
        for (char character : characters) {
            this.numbers.add(Character.getNumericValue(character));
        }
    }

    private void setRandomNumbers(int digit) {
        Permutation permutation = new Permutation(9, digit);
        permutation.rand();
        numbers = permutation.map(LOOK_UP_TABLE);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static int cutMinMax(int number, int min, int max) {
        return Math.max(Math.min(number, max), min);
    }
}
