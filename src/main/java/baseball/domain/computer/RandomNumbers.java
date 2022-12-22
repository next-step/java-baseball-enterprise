package baseball.domain.computer;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static baseball.util.constant.NumberConstant.*;
import static baseball.util.util.NumberUtils.generateRandomUniqueIntegerList;

public class RandomNumbers implements Iterable<Integer> {
    List<Integer> numbers;

    public RandomNumbers() {
        this.numbers = generateRandomUniqueIntegerList(3, RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }

    public RandomNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}
