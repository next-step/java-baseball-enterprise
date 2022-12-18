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

    // 사용자가 '112'처럼 중복 숫자를 입력할 때
    // 스트라이크와 볼이 중복 카운트되지 않도록
    // 포함하는 수 카운트에서 스트라이크를 빼서 볼을 계산
    public MatchResult match(int[] userArr) {
        int strike = countStrike(userArr);
        int ball = countContains(userArr) - strike;
        return new MatchResult(strike, ball);
    }

    private int countStrike(int[] userArr) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (numArr[i] == userArr[i])
                strike++;
        }
        return strike;
    }

    private int countContains(int[] userArr) {
        int contains = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (numArr[i] == userArr[j]) {
                    contains++;
                    break;
                }
            }
        }
        return contains;
    }

    public static int[] convertToList(int num) {
        return new int[]{
                num / 100,
                num / 10 % 10,
                num % 10
        };
    }
}
