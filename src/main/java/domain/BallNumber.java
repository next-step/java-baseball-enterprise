package domain;

import java.util.ArrayList;
import java.util.List;

public class BallNumber {

    private List<Integer> digits = new ArrayList<>();

    public BallNumber(List<Integer> numbers) {
        this.digits = new ArrayList<>();
        this.digits.addAll(numbers);
    }

    public int getLength() {
        return digits.size();
    }

    public List<Integer> getDigits() {
        return this.digits;
    }

}
