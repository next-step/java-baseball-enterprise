package baseball;

import java.io.IOException;

public class NumberBaseballApp {

    public static void main(String[] args) throws IOException {
        NumberBaseballGameManager numberBaseballGameManager = new NumberBaseballGameManager();

        boolean gameStart = true;
        while (gameStart) {
            gameStart = numberBaseballGameManager.playGame();
        }

        numberBaseballGameManager.close();
    }
}
