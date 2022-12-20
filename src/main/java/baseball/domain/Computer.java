package baseball.domain;

import baseball.domain.Result;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Computer {
    List<Integer> numbers = new ArrayList<>();

    public Computer() {
        this.numbers = generateNumberList();
    }

    public Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Result calculate(List<Integer> input) {
        Result result = new Result(0, 0);
        calculateStrike(input, result);
        calculateBall(input, result);
        return result;
    }

    private void calculateBall(List<Integer> input, Result result) {
        input.retainAll(numbers);
        result.addBall(input.size());
    }

    private void calculateStrike(List<Integer> input, Result result) {
        for(int i = 0 ; i < numbers.size() ; i++) {
            addValueIfIsStrike(input, result, i);
        }
    }

    private void addValueIfIsStrike(List<Integer> input, Result result, int i) {
        if(numbers.get(i).equals(input.get(i))) {
            result.addStrike();
        }
    }

    public List<Integer> generateNumberList() {
        List<Integer> numberList = new ArrayList<>();
        for(int i = 1 ; i <= 9 ; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList, new Random(System.nanoTime()));
        return numberList.subList(0, 3);
    }
}
