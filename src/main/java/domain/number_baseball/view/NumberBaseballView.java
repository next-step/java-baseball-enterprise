package domain.number_baseball.view;

import domain.number_baseball.common.NumberBaseballSetting;

import java.util.Scanner;

public final class NumberBaseballView {
    private static final Scanner sc = new Scanner(System.in);

    public String getInputStringFromPlayer() {
        System.out.print("숫자를 입력해주세요 : ");
        return sc.next();
    }

    public void printResult(int numberOfStrikes, int numberOfBalls) {
        if (numberOfBalls == 0 && numberOfStrikes == 0) {
            System.out.println("낫싱");
            return;
        }

        printIfLargerThanZero(numberOfStrikes, "스트라이크");
        printIfLargerThanZero(numberOfBalls, "볼");

        System.out.println();
    }

    private void printIfLargerThanZero(int num, String base) {
        if (num > 0) {
            System.out.printf("%d %s ", num, base);
        }
    }

    public String getInputFromPlayerForReplaying() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return sc.next();
    }

    public void finishSingleGame() {
        System.out.printf("%d개의 숫자를 모두 맞췄습니다! 게임 종료\n", NumberBaseballSetting.MAX_BALL_NUMBER);
    }

    public void finishEntireGame() {
        System.out.println("게임을 종료합니다.");
    }

    public void printWrongInputMessage() {
        System.out.println("잘못된 형식의 입력입니다.");
    }
}
