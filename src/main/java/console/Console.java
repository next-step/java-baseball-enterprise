package console;

import java.util.Scanner;

public class Console {

    private static final String ASK_GAME_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final Scanner scanner;

    public Console() {
        this.scanner = new Scanner(System.in);
    }

    public int getGameMenu(){
        System.out.println(ASK_GAME_AGAIN);
        return scanner.nextInt();
    }

    public int[] getPlayerAnswer(){
        int[] playerAnswer = new int[3];
        String input = scanner.nextLine();
        String[] splitNumber = input.split("");
        for(int idx = 0; idx < 3; idx++){
            playerAnswer[idx] = Integer.getInteger(splitNumber[idx]);
        }
        return playerAnswer;
    }
}
