package baseball.model.domain;

import baseball.model.domain.BaseballNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomBaseballNumberGenerator {

    private static final List<Integer> possibleNumbers = new ArrayList<>();

    static {
        for (int i = 0; i <= 9; i++) {
            possibleNumbers.add(i);
        }
    }

    private RandomBaseballNumberGenerator() {
    }

    public static BaseballNumber create() {
        Collections.shuffle(possibleNumbers);
        Integer firstDigit = possibleNumbers.get(0);
        Integer secondDigit = possibleNumbers.get(1);
        Integer thirdDigit = possibleNumbers.get(2);
        return new BaseballNumber(firstDigit, secondDigit, thirdDigit);
    }
}
