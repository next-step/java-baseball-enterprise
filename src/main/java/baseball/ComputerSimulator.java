package baseball;

import java.util.List;
import java.util.Scanner;

public class ComputerSimulator {
    List<Integer> answer;
    Scanner scanner = new Scanner(System.in);

    public void startNewGame() {
        answer = NumberGenerater.generate();

        while(true) {
            System.out.print("숫자를 입력해주세요: ");

            Integer input = scanner.nextInt();
        }
    }
}
