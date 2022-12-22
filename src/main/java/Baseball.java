import java.util.Random;
import java.util.Scanner;

public class Baseball {
    public static int generateNumbers() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int[] values = new int[3];
        values[0] = random.nextInt(8) + 1;
        do {
            values[1] = random.nextInt(8) + 1;
        } while (values[1] == values[0]);
        do {
            values[2] = random.nextInt(8) + 1;
        } while (values[2] == values[0] || values[2] == values[1]);
        return values[0] * 100 + values[1] * 10 + values[2];
    }

    public static void baseballGame() {

        int inputValue;
        BaseballValue answer, guess;
        Scanner sc = new Scanner(System.in);
        answer = new BaseballValue(generateNumbers());
        System.out.print(answer.getValues()[0] + " ");
        System.out.print(answer.getValues()[1] + " ");
        System.out.print(answer.getValues()[2] + " \n");
        // guess and check
        do {
            System.out.print("숫자를 입력해 주세요 : ");
            inputValue = sc.nextInt();
            guess = new BaseballValue(inputValue);
            guess.compare(answer);
            guess.printResult();
        } while (guess.getStrike() < 3);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int moreGame;
        do {
            baseballGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            moreGame = sc.nextInt();
        } while (moreGame == 1);
    }
}
