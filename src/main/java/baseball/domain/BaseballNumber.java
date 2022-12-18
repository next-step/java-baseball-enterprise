package baseball.domain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballNumber {

    private final List<Integer> candidateNumbers = new ArrayList<>();
    private final int[] baseballNumbers = new int[3];

    public BaseballNumber() {
        for (int i = 1; i <= 9; i++) {
            candidateNumbers.add(i);
        }
    }

    public void GenerateBaseballNumbers() {
        Collections.shuffle(candidateNumbers);
        for (int i = 0; i <= 2; i++) {
            baseballNumbers[i] = candidateNumbers.get(i);
        }
    }
}
