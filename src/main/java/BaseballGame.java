import java.util.Random;
import java.util.Scanner;


class BaseballGame {
    private String answerNumber;
    private final int numberLength;
    private final Scanner sc;
    private final Random random;
    private GameStatus gameStatus;

    BaseballGame() {
        numberLength = 3;
        sc = new Scanner(System.in);
        random = new Random();
        gameStatus = GameStatus.IN_GAME;
    }

    void start() {
        while (gameStatus == GameStatus.IN_GAME) {
            setRandomNumber();
            guessNumber();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    void setRandomNumber() {
        char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] results = new char[numberLength];
        for (int i = 0; i < numberLength; i++) {
            int j = random.nextInt(9 - i);
            results[i] = numbers[j];
            swap(numbers, j, 8 - i);
        }
        answerNumber = new String(results);
    }

    private void guessNumber() {
        Result result;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String submitNumber = sc.next();
            result = getResult(submitNumber);
            System.out.println(result.resultString());
        } while (!result.isCorrect());
    }

    Result getResult(String submitNumber) {
        return new Result(answerNumber, submitNumber);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


enum GameStatus {
    IN_GAME,
    TERMINATED,
}


enum MenuItem {
    START,
    EXIT,
    WRONG_INPUT,
}
