
public class BaseballGame {
    private View view = new View();
    private Computer computer = new Computer();
    private Player player = new Player();
    private boolean isRun = true;
    public void run() {
        while (isRun) {
            try {
                player.setNumbers(view.getPlayerInput());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            int[] scores = computer.calculateScores(player.getNumbers());
            view.printScore(scores);
            isRun = checkIsRun(scores);
        }
    }

    public boolean checkIsRun(int[] scores) {
        if (scores[0] != 3) return true;
        try {
            if (scores[0] == 3) return checkIsFinish(view.getPlayerRetryChoice());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean checkIsFinish(boolean playerRetryChoice) {
        if (playerRetryChoice == true) {
            computer.resetRandomNumbers();
            return true;
        }
        return false;
    }

}
