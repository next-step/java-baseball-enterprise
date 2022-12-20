import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Computer {
    private Integer[] randomNumbers = new Integer[3];

    Computer() {
        resetRandomNumbers();
    }

    public Integer[] getRandomNumbers() {
        return randomNumbers;
    }

    private void resetRandomNumbers() {
        randomNumbers = getThreeUniqueRandomNumbers();
    }
    public Integer[] getThreeUniqueRandomNumbers() {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < 3) {
            Double d = Math.random() * 9 + 1;
            numberSet.add(d.intValue());
        }
        Integer[] numbers = numberSet.toArray(new Integer[0]);
        Collections.shuffle(Arrays.asList(numbers));
        return numbers;
    }
}
