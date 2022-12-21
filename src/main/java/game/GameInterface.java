package game;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameInterface {
    private final Scanner scanner;
    private final PrintStream printer;

    public GameInterface() {
        this.scanner = new Scanner(System.in);
        this.printer = System.out;
    }

    public GameInterface(InputStream input, OutputStream output) {
        this.scanner = new Scanner(input);
        this.printer = new PrintStream(output);
    }

    public void printHints() {
        this.printer.println("=== 숫자 야구 게임 ===");
        this.printer.println("3개의 랜덤으로 설정된 숫자를 맞추는 게임입니다.");
        this.printer.println("입력한 숫자가 위치와 값이 모두 일치하는 경우 스트라이크, 숫자가 존재하긴 하지만 위치가 다르다면 볼입니다.");
        this.printer.println("예시) ");
        this.printer.println("     [맞춰야 하는 값] : 321");
        this.printer.println("     [사용자 입력]숫자를 입력해 주세요 : 123");
        this.printer.println("     [입력 결과] 1스트라이크 2 볼");
        this.printer.println("     [사용자 입력]숫자를 입력해 주세요 : 321");
        this.printer.println("     [입력 결과] 3스트라이크!");
        this.printer.println("     [게임 종료]");
        this.printer.println("     [주의사항] 숫자는 1~9 사이의 값 3개를 위의 예시처럼 붙여서 사용해 주세요.");
        this.printer.println();
    }
    public void printGameResult(GameResult gameResult) {
        if (gameResult.strike == 0 && gameResult.ball == 0) {
            this.printer.println("낫싱");
            return;
        }
        if (gameResult.strike != 0) {
            this.printer.printf("%d 스트라이크 ", gameResult.strike);
        }
        if (gameResult.ball != 0) {
            this.printer.printf("%d 볼 ", gameResult.ball);
        }
        this.printer.println();
    }

    public int[] scanUserNumber() {
        inputloop: while (true){
            this.printer.print("숫자를 입력해 주세요(예시 : 123) : ");
            var inputLine = this.scanner.next();
            if (!inputLine.matches("^[0-9]{3}$")) {
                continue inputloop;
            }
            return new int[]{
                    (int) (inputLine.charAt(0) - '0'), // 명시적인 타입 캐스팅, 필수는 아님.
                    (int) (inputLine.charAt(1) - '0'), //
                    (int) (inputLine.charAt(2) - '0'), //
            };
        }
    }

    public int scanRetryMenu() {
        inputloop: while (true){
            this.printer.print("게임을 다시 진행하려면 1, 종료하려면 2를 입력하세요 : ");
            try {
                var menu = this.scanner.nextInt();
                if(!(1 <= menu && menu <= 2)){
                    continue inputloop;
                }
                return menu;
            }catch (InputMismatchException ime){
                this.printer.println("잘못된 값이 입력되었습니다. 1, 2중에 선택하세요. : ");
            }
        }
    }
}
