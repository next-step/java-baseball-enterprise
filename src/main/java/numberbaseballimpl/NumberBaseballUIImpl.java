package numberbaseballimpl;

import numberbaseball.Hint;
import numberbaseball.NumberBaseballUI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberBaseballUIImpl implements NumberBaseballUI {
    private final Scanner scanner;

    private NumberBaseballUIImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    public static NumberBaseballUI from(Scanner scanner) {
        return new NumberBaseballUIImpl(scanner);
    }

    @Override
    public int inputBall() {
        int ball;
        do {
            printBallInput();
            ball = getInt();
        } while (ball == -1);
        return ball;
    }

    private int getInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            printInputError();
            scanner.nextLine();
            return -1;
        }
    }

    private static void printBallInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void printInputError() {
        System.out.println("올바른 입력이 아닙니다.");
    }

    @Override
    public void printHint(Hint hint) {
        if (hint.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        String hintString = toString(hint);
        System.out.println(hintString);
    }

    private static String toString(Hint hint) {
        StringBuilder sb = new StringBuilder();
        if (hint.hasStrike()) {
            sb.append(hint.getStrike()).append(" 스트라이크 ");
        }
        if (hint.hasBall()) {
            sb.append(hint.getBall()).append("볼");
        }
        return sb.toString();
    }

    @Override
    public int inputContinue() {
        int result;
        do {
            printContinueInput();
            result = getInt();
        } while (result == -1);
        return result;
    }

    private static void printContinueInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Override
    public void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
