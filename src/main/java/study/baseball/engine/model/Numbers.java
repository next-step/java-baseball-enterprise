package study.baseball.engine.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(Set<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBall(List<Integer> input) {
        Set<Integer> sum = new HashSet<>(input);
        sum.addAll(numbers);
        return input.size() + numbers.size() - sum.size() - getStrike(input);
    }

    public Integer getStrike(List<Integer> input) {
        Iterator<Integer> numbersIterator = numbers.iterator();
        int index = 0;
        int strike = 0;
        while (numbersIterator.hasNext()) {
            if (Objects.equals(numbersIterator.next(), input.get(index++))) {
                strike++;
            }
        }
        return strike;
    }
}
