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
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            handleMenuSelect();
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

    // for test
    void setSpecificNumber(String number) {
        answerNumber = number;
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

    private void handleMenuSelect() {
        MenuItem menu;
        do {
            menu = getMenuItem();
        } while (menu == MenuItem.WRONG_INPUT);
        if (menu == MenuItem.EXIT) {
            gameStatus = GameStatus.TERMINATED;
        }
    }

    private MenuItem getMenuItem() {
        String menuNumber = sc.next();
        if (menuNumber.equals("1")) {
            return MenuItem.START;
        } else if (menuNumber.equals("2")) {
            return MenuItem.EXIT;
        }
        return MenuItem.WRONG_INPUT;
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
