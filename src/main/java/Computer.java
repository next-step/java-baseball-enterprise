import java.util.Arrays;
import java.util.Random;

public class Computer {
    private static final int NUMBER_NOT_SELECTED = -1;
    private static final int NUMBER_BOUND = 9;
    private static final int NUMBER_COUNT = 3;
    private int[] numbers = new int[NUMBER_COUNT];

    public Computer() {
        Arrays.fill(numbers, NUMBER_NOT_SELECTED);
    }

    public Computer(int[] givenNumbers) {
        numbers = givenNumbers;
    }

    public boolean containsNumber(int newNumber) {
        boolean flag = false;
        for (int number : numbers) {
            flag = (number == newNumber) || flag;
        }
        return flag;
    }

    public int getUniqueNumber() {
        int number = new Random().nextInt(NUMBER_BOUND)+1;
        while (containsNumber(number)) {
            number = new Random().nextInt(NUMBER_BOUND)+1;
        }
        return number;
    }

    public void selectNumbers() {
        for (int i = 0; i<numbers.length; i++) {
            numbers[i] = getUniqueNumber();
        }
    }

    public int isStrike(int number, int idx) {
        return numbers[idx]==number ? 1 : 0;
    }

    public int isBall(int number, int idx) {
        if (numbers[(idx+1)%3]==number) {
            return 1;
        }
        if (numbers[(idx+2)%3]==number) {
            return 1;
        }
        return 0;
    }

    public int[] calculate(int[] inputs) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i<inputs.length; i++) {
            strike = strike + isStrike(inputs[i], i);
            ball = ball + isBall(inputs[i], i);
        }
        return new int[] {strike, ball};
    }
}
