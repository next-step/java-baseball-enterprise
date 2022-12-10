package baseball.domain;

import java.util.List;

import static baseball.GameService.*;

public class Player {

    private final List<Integer> numbers;

    public Player(List<Integer> numbers) {
        checkValidSize(numbers);
        checkDuplicate(numbers);
        checkValidRange(numbers);
        this.numbers = numbers;
    }

    static void checkValidSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("잘못된 숫자 길이입니다.");
        }
    }

    static void checkDuplicate(List<Integer> numbers) {
        if (getDistinctSize(numbers) != numbers.size()) {
            throw new IllegalArgumentException("중복되는 숫자가 있습니다.");
        }
    }

    private static long getDistinctSize(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    static void checkValidRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(Player::isOutOfRange)) {
            throw new IllegalArgumentException("잘못된 숫자 범위입니다.");
        }
    }

    private static boolean isOutOfRange(int number) {
        return MIN_NUMBER > number || number > MAX_NUMBER;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
