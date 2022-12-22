package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballNumber {
    private static final int BASEBALL_NUMBER_LENGTH = 3;
    private final List<Integer> candidateNumbers = new ArrayList<>();
    private List<Integer> number = new ArrayList<>();

    public BaseballNumber() {
        for (int i = 1; i <= 9; i++) {
            candidateNumbers.add(i);
        }
    }

    public void generateBaseballNumber() {
        number.clear();
        Collections.shuffle(candidateNumbers);
        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
            number.add(candidateNumbers.get(i));
        }
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setNumber(List<Integer> number) {
        this.number = number;
    }
}
