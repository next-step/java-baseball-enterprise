import java.util.Random;

public class NumSet {
    private int[] numArr = new int[3];

    public NumSet() {
        for (int i = 0; i < 3; i++)
            setRandomNum(i);
    }

    private void setRandomNum(int idx) {
        Random random = new Random();
        boolean isDiff = false;
        while (!isDiff) {
            numArr[idx] = random.nextInt(1, 10);
            isDiff = isDiffFromForward(idx);
        }
    }

    private boolean isDiffFromForward(int idx) {
        boolean isPrevDiff = true;
        for (int i = 0; i < idx; i++)
            isPrevDiff = isPrevDiff && (numArr[idx] != numArr[i]);
        return isPrevDiff;
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
        for (int i = 0; i < 3; i++)
            strike += (numArr[i] == userArr[i]) ? 1 : 0;    // depth 1로 만들기 위해...
        return strike;
    }

    private int countContains(int[] userArr) {
        int cnt = 0;
        for (int i = 0; i < 3; i++)
            cnt += contains(i, userArr) ? 1 : 0;
        return cnt;
    }

    private boolean contains(int idx, int[] userArr) {
        boolean hasNum = false;
        for (int i = 0; i < 3; i++)
            hasNum = hasNum || (numArr[idx] == userArr[i]);
        return hasNum;
    }

    public static int[] convertToList(int num) {
        return new int[]{
                num / 100,
                num / 10 % 10,
                num % 10
        };
    }
}
