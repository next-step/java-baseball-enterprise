package study.baseball.engine;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import study.baseball.engine.model.Numbers;

public class NumberGenerator {
    private final Random random = new Random();

    public Numbers generateRandomNumber() {
        Set<Integer> randomNumbers = new LinkedHashSet<>();
        while (randomNumbers.size() < 3) {
            randomNumbers.add(random.nextInt(10));
        }
        return new Numbers(randomNumbers);
    }
}
