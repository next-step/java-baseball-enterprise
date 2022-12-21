import java.util.Scanner;

public class Main {
    private static AnswerEntity answer;
    private static int[] input;
    private static boolean isFinish;
    private static GameInputScanner gameInputScanner;
    private static GameService gameService;

    public static void main(String[] args) {
        do{
            setUp();
            System.out.println(answer.getAnswer()[0] + ""+answer.getAnswer()[1] + ""+answer.getAnswer()[2]);
            startGame();
        }while(restartOrNot());
    }
    private static void setUp(){
        isFinish = false;
        answer = new AnswerEntity();
        gameInputScanner = new GameInputScanner();
        gameService = new GameService();
    }
    private static void startGame(){
        while(!isFinish){
            input = gameInputScanner.getGameInput();
            ResultEntity result = gameService.getResult(answer.getAnswer(), input);
            isFinish = gameService.isFinish(result);
        }
    }
    private static boolean restartOrNot(){
        int cmd = gameInputScanner.getRestartInput();
        if(cmd == 1) return true;

        return false;
    }


}
