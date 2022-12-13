package baseball.testdoubles;

import baseball.model.Numbers;
import baseball.model.NumbersGenerator;

public class StubNumbersGenerator implements NumbersGenerator {

    private final String[] numbers;
    private int index;

    public StubNumbersGenerator(String... numbers) {
        this.numbers = numbers;
        this.index = 0;
    }

    @Override
    public Numbers generate() {
        return Numbers.from(numbers[index++]);
    }
}
