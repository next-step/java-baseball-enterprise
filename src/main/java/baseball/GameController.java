package baseball;

public class GameController {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.start();
    }
}
