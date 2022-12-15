package baseball.view;

import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.util.StringListIntegerConvertor;
import baseball.util.StringToIntegerConvertor;

import java.util.Scanner;

import static baseball.GameService.NUMBERS_SIZE;

public class GameView {

    static Scanner scanner = new Scanner(System.in);

    public static Player inputPlayer() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();
        return new Player(StringListIntegerConvertor.convert(input));
    }

    public static int getRetryCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        int command = StringToIntegerConvertor.convert(input);
        return command;
    }

    public static void printResult(GameResult result) {
        System.out.println(getResultText(result));
    }

    private static String getResultText(GameResult result) {
        if (result.getBall() == 0 && result.getStrike() == 0) {
            return "낫싱";
        }
        if (result.getStrike() == NUMBERS_SIZE) {
            return "3스트라이크\n" +
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        return strikeText(result.getStrike()) + ballText(result.getBall());
    }

    private static String strikeText(int strike) {
        if (strike == 0) {
            return "";
        }
        return strike + "스트라이크 ";
    }

    private static String ballText(int ball) {
        if (ball == 0) {
            return "";
        }
        return ball + "볼";
    }
}
