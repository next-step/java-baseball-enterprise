import game.BaseballGame;
import service.RandomGenerator;

public class Application {
    public static void main(String[] args) {
        RandomGenerator.generateRandomNumber();
        Boolean keepPlaying = true;
        while (keepPlaying) {
            BaseballGame baseballGame = new BaseballGame();
            keepPlaying = baseballGame.playGame();
        }
    }
}
