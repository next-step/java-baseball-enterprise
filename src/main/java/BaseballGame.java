import java.util.Locale;

public class BaseballGame {
    private View view = new View();
    private Computer computer = new Computer();
    private Player player = new Player();
    private boolean isRun = true;
    public void run() {
        while (isRun) {
            player.setNumbers(view.getPlayerInput());
            int[] scores = computer.calculateScores(player.getNumbers());
            view.printScore(scores);
        }
    }
}
