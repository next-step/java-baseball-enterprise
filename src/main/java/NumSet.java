import java.util.Random;

public class NumSet {
    private int[] numArr = new int[3];

    public NumSet() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            while (true) {
                numArr[i] = random.nextInt(1, 10);
                if (isDiffFromForward(i))
                    break;
            }
        }
    }

    private boolean isDiffFromForward(int idx) {
        for (int i = 0; i < idx; i++) {
            if (numArr[idx] == numArr[i])
                return false;
        }
        return true;
    }

    public static int[] convertToList(int num) {
        return new int[]{
                num / 100,
                num / 10 % 10,
                num % 10
        };
    }
}
