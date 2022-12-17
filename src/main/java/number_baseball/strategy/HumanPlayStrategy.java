package number_baseball.strategy;

import global.exceptions.IllegalGameArgumentException;
import java.util.Scanner;
import number_baseball.enums.GameSettings;
import number_baseball.model.GameResult;
import number_baseball.model.InputAnswer;

public class HumanPlayStrategy implements NumberBaseBallStrategy {

    @Override
    public InputAnswer offerNumber() throws IllegalGameArgumentException {
        System.out.printf("상대가 맞출 %d자리 숫자를 입력해주세요: ", GameSettings.MAX_LENGTH);
        Scanner sc = new Scanner(System.in);

        return new InputAnswer(sc.next());
    }

    @Override
    public GameResult verifyAnswer(String dst, String src) {

        return GameResult.builder()
                .strike(countStrike(dst, src))
                .ball(countBall(dst, src, 0))
                .build()
                ;
    }

    private int countStrike(String dst, String src) {
        int count = 0;
        for (int i = 0; i < dst.length(); i++) {
            count += dst.charAt(i) == src.charAt(i) ? 1 : 0;
        }

        return count;
    }

    private int countBall(String dst, String src, int index) {
        if (index >= dst.length()) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < dst.length(); i++) {
            count += dst.charAt(index) == src.charAt(i) && i != index ? 1 : 0;
        }

        return countBall(dst, src, index + 1) + count;
    }
}
