package baseball;

import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.util.StringListIntegerConvertor;
import baseball.util.StringToIntegerConvertor;

import java.util.Scanner;

public class GameService {
    public static final int NUMBERS_SIZE = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    static Scanner scanner = new Scanner(System.in);
    Computer computer;
    Player player;

    public void play(Computer computer) {
        this.computer = computer;
        GameResult result;
        do {
            player = inputPlayer();
            result = GameResult.getResult(player.getNumbers(), computer.getNumbers());
            result.print();
        } while (result.isGameContinue(NUMBERS_SIZE));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    Player inputPlayer() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();
        return new Player(StringListIntegerConvertor.convert(input));
    }

    public static boolean wantRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        int command = StringToIntegerConvertor.convert(input);
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
            for (GameEndStatus value : values()) {
                if (value.command == playerInput) {
                    return;
                }
            }
            throw new IllegalArgumentException("1 혹은 2를 입력하셔야 합니다. 입력한 숫자: " + playerInput);
        }
    }
}
