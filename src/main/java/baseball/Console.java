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
            System.out.println("낫씽");
        } else if (strike == 0) {
            System.out.println(ball + " 볼");
        } else if (ball == 0) {
            System.out.println(strike + " 스트라이크");
        } else {
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
        }
    }

    public int endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
