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
