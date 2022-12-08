package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomBaseballNumberGenerator {
    public static List<Integer> generateRandomBaseballNumber() {
        List<Integer> digits = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(digits);
        return digits.subList(0, 3);
    }
}
