package baseball.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.GameService.*;

public class Computer {

    List<Integer> numbers;

    private Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Computer newInstance() {
        return new Computer(generateRandomUniqueNumbers(MIN_NUMBER, MAX_NUMBER, NUMBERS_SIZE));
    }

    public static Computer of(List<Integer> numbers) {
        return new Computer(numbers);
    }

    static List<Integer> generateRandomUniqueNumbers(int startInclude, int endInclude, int size) {
        checkValidRange(startInclude, endInclude);
        checkValidSize(startInclude, endInclude, size);
        List<Integer> numberSequence = IntStream.range(startInclude, endInclude + 1)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numberSequence);
        return numberSequence.subList(0, size);
    }

    private static void checkValidRange(int startInclude, int endInclude) {
        if (endInclude < startInclude) {
            throw new IllegalArgumentException("랜덤 값의 시작값이 끝값보다 큽니다.");
        }
    }

    private static void checkValidSize(int startInclude, int endInclude, int size) {
        if (endInclude - startInclude + 1 < size) {
            throw new IllegalArgumentException("범위보다 구하려는 size가 더 큽니다.");
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
