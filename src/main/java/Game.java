import java.util.Scanner;

public class Game {
    private NumSet answer;

    public void reset() {
        answer = new NumSet();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean isCorrect = false;
        while (!isCorrect) {
            System.out.print("숫자를 입력해주세요 : ");
            int[] submitted = NumSet.convertToList(sc.nextInt());

            MatchResult matchResult = answer.match(submitted);
            matchResult.printResult();

            isCorrect = matchResult.isCorrect();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean willContinue() {
        Scanner sc = new Scanner(System.in);

        int next = 0;
        while (next != 1 && next != 2) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            next = sc.nextInt();
        }

        return next == 1;
    }
}
