import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int[] answer;
    private static int[] input;
    private static boolean isFinish;
    private static GameInputScanner gameInputScanner;

    public static void main(String[] args) {
        setUp();
        startGame();
    }
    private static void setUp(){
        Random random = new Random();
        isFinish = false;
        answer = new int[3];
        gameInputScanner = new GameInputScanner();

        for(int i = 0; i < 3; i++){
            answer[i] = random.nextInt(9) + 1;
        }
    }
    private static void startGame(){
        while(!isFinish){
            input = gameInputScanner.getInput();
        }
    }


}
