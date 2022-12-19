package baseball.domain;

import baseball.constant.Constant;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private final List<Integer> numbers;
    private final int length = Constant.LENGTH.getValue();

    public BaseballNumbers() {
        numbers = new ArrayList<>();
    }

    public BaseballNumbers(String[] input) {
        this();
        for (String num : input) {
            this.add(Integer.parseInt(num));
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public boolean add(int number) {
        if (!contains(number)) {
            numbers.add(number);
        }
        return isFull();
    }

    public boolean isFull() {
        return numbers.size() == length;
    }

    public int getNumberAt(int index) {
        return numbers.get(index);
    }

    public int getIndex(int number) {
        return numbers.indexOf(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BaseballNumbers) {
            return numbers.equals(((BaseballNumbers) obj).numbers);
        }
        return false;
    }
}
