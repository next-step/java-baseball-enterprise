package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.constant.NumberConstant.*;
import static baseball.util.util.NumberUtils.generateRandomUniqueIntegerList;

public class Computer {
    List<Integer> numbers = new ArrayList<>();

    public Computer() {
        this.numbers = generateRandomUniqueIntegerList(RANDOM_NUMBER_SIZE, RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }

    public Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Result calculateResult(List<Integer> input) {
        int strike = calculateStrike(input);
        return new Result(strike, calculateBall(input) - strike);
    }

    private int calculateBall(List<Integer> input) {
        input.retainAll(numbers);
        return input.size();
    }

    private int calculateStrike(List<Integer> input) {
        int strike = 0;
        for(int i = 0 ; i < numbers.size() ; i++) {
            strike += isStrike(input, i);
        }
        return strike;
    }

    private int isStrike(List<Integer> input, int i) {
        return numbers.get(i).equals(input.get(i)) ? 1 : 0;
    }
}
