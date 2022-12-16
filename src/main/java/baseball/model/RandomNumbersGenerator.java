package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {

    private static final int MIN = 1;
    private static final int MAX = 9;

    @Override
    public Numbers generate() {
        List<String> numbers = generateNumbersInRange(MIN, MAX);
        String numbersText = createRandomNumbersText(numbers);
        return Numbers.from(numbersText);
    }

    private List<String> generateNumbersInRange(int min, int max) {
        List<String> numbers = new ArrayList<>();
        for (int value = min; value <= max; value++) {
            numbers.add(String.valueOf(value));
        }
        return numbers;
    }

    private String createRandomNumbersText(List<String> numbers) {
        Collections.shuffle(numbers);
        return String.join("", numbers.subList(0, 3));
    }
}
