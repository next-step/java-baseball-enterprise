package baseball;

import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.view.GameView;


public class GameService {
    public static final int NUMBERS_SIZE = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    Computer computer;
    Player player;

    public void play(Computer computer) {
        this.computer = computer;
        GameResult result;
        do {
            player = GameView.inputPlayer();
            result = GameResult.getResult(player.getNumbers(), computer.getNumbers());
            GameView.printResult(result);
        } while (result.isGameContinue(NUMBERS_SIZE));
    }

    public static boolean wantRetry() {
        int command = GameView.getRetryCommand();
        GameEndStatus.validate(command);
        return command == GameEndStatus.RETRY.command;
    }

    private enum GameEndStatus {
        RETRY(1), QUIT(2);

        final int command;

        GameEndStatus(int command) {
            this.command = command;
        }

        static void validate(int playerInput) {
            boolean isValid = false;
            for (GameEndStatus value : values()) {
                isValid |= (value.command == playerInput);
            }
            if (isValid) {
                return;
            }
            throw new IllegalArgumentException("1 혹은 2를 입력하셔야 합니다. 입력한 숫자: " + playerInput);
        }
    }
}
