package number_baseball.model;

import lombok.Builder;
import lombok.Getter;
import number_baseball.enums.GameSettings;

@Getter
@Builder
public class GameResult {

    private int strike;

    private int ball;

    public boolean isFinished() {
        return strike == GameSettings.MAX_LENGTH;
    }

    public void printResult() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strike > 0) {
            System.out.printf("%d 스트라이크 ", this.strike);
        }

        if (ball > 0) {
            System.out.printf("%d 볼 ", this.ball);
        }

        System.out.println();
    }
}
