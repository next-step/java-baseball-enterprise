import java.util.Random;

public class Main {
    private static AnswerEntity answer;
    private static int[] input;
    private static boolean isFinish;
    private static GameInputScanner gameInputScanner;
    private static GameService gameService;

    public static void main(String[] args) {
        setUp();
        startGame();
    }
    private static void setUp(){
        isFinish = false;
        answer = new AnswerEntity();
        gameInputScanner = new GameInputScanner();
        gameService = new GameService();
    }
    private static void startGame(){
        while(!isFinish){
            input = gameInputScanner.getInput();
            ResultEntity result = gameService.getResult(answer.getAnswer(), input);
            isFinish = gameService.isFinish(result);
        }
    }


}
