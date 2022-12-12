package baseball;

import baseball.constant.Constant;
import baseball.domain.BaseballNumbers;

import java.util.Random;

public class BaseballNumbersGenerator {
    Random random;
    private final int MIN = Constant.MIN_RANGE.getValue();
    private final int MAX = Constant.MAX_RANGE.getValue();
    public BaseballNumbersGenerator(){
        random = new Random();
    }
    public BaseballNumbers generate() {
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        boolean isFull = false;
        while(!isFull) {
            int nextNumber = MIN + random.nextInt(MAX-MIN);
            isFull = baseballNumbers.add(nextNumber);
        }
        return baseballNumbers;
    }
}
