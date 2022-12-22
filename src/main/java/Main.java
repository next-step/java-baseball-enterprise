import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Baseball baseball = new Baseball();
        int moreGame;
        do {
            baseball.baseballGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            moreGame = sc.nextInt();
        } while (moreGame == 1);
    }
}
