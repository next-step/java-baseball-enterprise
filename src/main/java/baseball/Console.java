package baseball;
import java.util.Scanner;

public class Console {
    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void printResult(int strike, int ball) {
        if (strike + ball == 0) {
            System.out.print("낫씽");
        }
        if (strike != 0) {
            System.out.print(strike + " 스트라이크 ");
        }
        if (ball != 0) {
            System.out.print(ball + " 볼");
        }
        System.out.println();
    }

    public int endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
