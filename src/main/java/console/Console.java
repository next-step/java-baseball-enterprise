package console;

import game.Score;

import java.util.ArrayList;
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

    public ArrayList<Integer> getPlayerAnswer(){
        ArrayList<Integer> playerAnswer = new ArrayList<>(3);
        String input = scanner.nextLine();
        String[] splitNumber = input.split("");
        for(int idx = 0; idx < 3; idx++){
            playerAnswer.add(Integer.getInteger(splitNumber[idx]));
        }
        return playerAnswer;
    }

    public void printScore(Score score){
    }
}
