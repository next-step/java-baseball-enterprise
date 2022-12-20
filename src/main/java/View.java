import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class View {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Integer[] getPlayerInput() throws IOException {
        System.out.println("숫자를 입력해주세요 : ");
        String input = reader.readLine();
        String[] numbersInString = input.split("");
        Integer[] numbers = new Integer[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(numbersInString[i]);
        }
        return numbers;
    }

    public void printScore(int[] scores) {
        String strike = "";
        String ball = "";
        if (scores[0] != 0) strike = scores[0] + "스트라이크 ";
        if (scores[1] != 0) ball = scores[1] + "볼 ";
        if (scores[0]+scores[1] != 0) System.out.println(strike + ball);
        if (scores[0]+scores[1] == 0) System.out.println("낫싱");
    }

    public boolean getPlayerRetryChoice() throws IOException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerChoice = reader.readLine();
        if (playerChoice.equals("1")) return true;
        if (playerChoice.equals("2")) return false;
        return false;
    }
}
