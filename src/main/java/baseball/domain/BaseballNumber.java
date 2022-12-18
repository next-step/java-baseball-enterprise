package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballNumber {

    private final List<Integer> candidateNumbers = new ArrayList<>();
    private final List<Integer> numbers = new ArrayList<>();

    public BaseballNumber() {
        for (int i = 1; i <= 9; i++) {
            candidateNumbers.add(i);
        }
    }

    public void GenerateBaseballNumbers() {
        numbers.clear();
        Collections.shuffle(candidateNumbers);
        for (int i = 0; i <= 2; i++) {
            numbers.add(candidateNumbers.get(i));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
