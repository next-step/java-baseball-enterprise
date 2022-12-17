package domain.ballnumber;

import java.util.ArrayList;
import java.util.List;

public class BallNumber {

    private List<Integer> digits;

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
