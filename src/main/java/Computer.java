import java.util.Random;

public class Computer {
    private int[] numbers = {-1,-1,-1};

    public Computer() {}

    public Computer(int[] givenNumbers) {
        numbers = givenNumbers;
    }

    public boolean contains(int newNumber) {
        boolean flag = false;
        for (int number : numbers) {
            flag = (number == newNumber) || flag;
        }
        return flag;
    }

    public int getUniqueNumber() {
        int number = new Random().nextInt(9)+1;
        while (contains(number)) {
            number = new Random().nextInt(9)+1;
        }
        return number;
    }

    public void selectNumbers() {
        for (int i = 0; i<3; i++) {
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
