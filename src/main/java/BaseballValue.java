public class BaseballValue {
    private final int[] values = new int[3];
    private final int[] count = new int[10];
    private int strike;
    private int ball;

    public BaseballValue(int newValues) {
        for (int i = 0; i < 10; i++) count[i] = 0;
        for (int i = 2; i >= 0; i--) {
            values[i] = newValues % 10;
            newValues /= 10;
            count[values[i]] = 1;
        }
        strike = 0;
        ball = 0;
    }

    public int[] getValues() {
        return values;
    }

    public int[] getCount() {
        return count;
    }

    public int getStrike() {
        return strike;
    }

    private int compareValue(int input1, int input2) {
        if (input1 == input2) {
            return 1;
        }
        return 0;
    }

    public void compare(BaseballValue comp) {
        int[] compValue = comp.getValues();
        int[] compCount = comp.getCount();
        for (int i = 0; i < 3; i++) {
            strike += compareValue(values[i], compValue[i]);
            ball += compCount[values[i]];
        }
        ball -= strike;
    }

    public void printResult() {
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.print("\n");
    }
}

