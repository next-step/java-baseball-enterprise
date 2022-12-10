package baseball;

import baseball.domain.Computer;

public class Main {
    public static void main(String[] args) {
        do {
            GameService gameService = new GameService();
            gameService.play(Computer.newInstance());
        } while (GameService.wantRetry());
    }
}
