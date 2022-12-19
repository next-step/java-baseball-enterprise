package numberbaseballimpl;

import numberbaseball.*;

import java.util.Scanner;

public class NumberBaseballImpl implements NumberBaseball {
    private static final int CONTINUE = 1;
    private static final int END = 2;
    private final Enemy enemy;
    private final NumberBaseballUI ui;

    private NumberBaseballImpl() {
        Base base = BaseImpl.createRandomBase();
        enemy = EnemyImpl.from(base);
        ui = NumberBaseballUIImpl.from(new Scanner(System.in));
    }

    public static NumberBaseball create() {
        return new NumberBaseballImpl();
    }

    @Override
    public void playGame() {
        boolean isContinue = true;
        while (isContinue) {
            enemyReset();
            playRound();
            ui.printEnd();
            isContinue = inputContinue();
        }
    }

    private void enemyReset() {
        Base base = BaseImpl.createRandomBase();
        enemy.reset(base);
    }

    private void playRound() {
        boolean solved = false;
        while (!solved) {
            Ball ball = inputBall();
            Hint hint = enemy.shoot(ball);
            ui.printHint(hint);
            solved = hint.isAnswer();
        }
    }

    private Ball inputBall() {
        Ball ball = null;
        while (ball == null) {
            int number = ui.inputBall();
            ball = createValidBall(number);
        }
        return ball;
    }

    private Ball createValidBall(int number) {
        try {
            return BallImpl.from(number);
        } catch (IllegalArgumentException ex) {
            ui.printInputError();
            return null;
        }
    }

    private boolean inputContinue() {
        int flag = -1;
        while (flag == -1) {
            flag = getValidFlag();
        }
        return flag == CONTINUE;
    }

    private int getValidFlag() {
        int flag = ui.inputContinue();
        if (flag != CONTINUE && flag != END) {
            ui.printInputError();
            return -1;
        }
        return flag;
    }
}
