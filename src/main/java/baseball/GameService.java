package baseball;

import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.util.StringListIntegerConvertor;

import java.util.Scanner;

public class GameService {
    public static final int NUMBERS_SIZE = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    Scanner scanner = new Scanner(System.in);
    Computer computer;
    Player player;

    public void play() {
        computer = Computer.newInstance();
        GameResult result;
        do {
            player = inputPlayer();
            result = GameResult.getResult(player.getNumbers(), computer.getNumbers());
            result.print();
        } while (result.isGameContinue(NUMBERS_SIZE));
    }

    Player inputPlayer() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();
        return new Player(StringListIntegerConvertor.convert(input));
    }
}
