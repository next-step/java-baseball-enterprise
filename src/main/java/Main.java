import numberbaseball.*;
import numberbaseballimpl.BallImpl;
import numberbaseballimpl.BaseImpl;
import numberbaseballimpl.EnemyImpl;
import numberbaseballimpl.NumberBaseballUIImpl;

import java.util.Scanner;

public class Main {

    private static Enemy enemy;
    private static NumberBaseballUI ui;

    public static void main(String[] args) {
        Base base = BaseImpl.createRandomBase();
        enemy = EnemyImpl.from(base);
        ui = NumberBaseballUIImpl.from(new Scanner(System.in));
        playNumberBaseball();
    }

    private static void playNumberBaseball() {
        boolean isContinue = true;
        while (isContinue) {
            Base base = BaseImpl.createRandomBase();
            enemy.reset(base);
            playNumberBaseballRound();
            ui.printEnd();
            isContinue = isContinue();
        }
    }

    private static void playNumberBaseballRound() {
        boolean solved = false;
        while (!solved) {
            Ball ball = createBall();
            Hint hint = enemy.shoot(ball);
            ui.printHint(hint);
            solved = hint.isAnswer();
        }
    }

    private static Ball createBall() {
        Ball ball = null;
        while (ball == null) {
            int number = ui.inputBall();
            ball = createBallIfValid(number);
        }
        return ball;
    }

    private static Ball createBallIfValid(int number) {
        try {
            return BallImpl.from(number);
        } catch (IllegalArgumentException ex) {
            ui.printInputError();
            return null;
        }
    }

    private static boolean isContinue() {

        int flag = -1;
        while (flag == -1) {
            flag = getFlag();
        }
        return flag == 1;
    }

    private static int getFlag() {
        int flag = ui.inputContinue();
        if (flag != 1 && flag != 2) {
            ui.printInputError();
            return -1;
        }
        return flag;
    }
}
