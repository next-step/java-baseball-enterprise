import java.util.Random;
import java.util.Scanner;

public class Baseball {
    private final Random random;
    private final Scanner sc;

    public Baseball() {
        random = new Random();
        random.setSeed(System.currentTimeMillis());
        sc = new Scanner(System.in);
    }

    private int generateNumbers() {
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

    private int userInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        return sc.nextInt();
    }

    private void clearGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void baseballGame() {
        int inputValue;
        BaseballValue answer, guess;
        answer = new BaseballValue(generateNumbers());
        do {
            inputValue = userInput();
            guess = new BaseballValue(inputValue);
            guess.compare(answer);
            guess.printResult();
        } while (guess.getStrike() < 3);
        clearGame();
    }


}
