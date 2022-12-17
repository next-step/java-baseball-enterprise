package number_baseball.view;

import global.exceptions.IllegalGameArgumentException;
import java.util.Scanner;
import number_baseball.enums.GameSettings;
import number_baseball.model.InputAnswer;

public class GameView {

    public InputAnswer getAnswerFromPlayer() throws IllegalGameArgumentException {
        System.out.print("숫자를 입력해주세요: ");
        Scanner sc = new Scanner(System.in);

        return new InputAnswer(sc.next());
    }

    public int askRetryGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }

    public void successGame() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! ", GameSettings.MAX_LENGTH);
        System.out.println("게임 종료");
    }
}
