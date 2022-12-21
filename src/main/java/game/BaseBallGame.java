package game;

import opponent.Opponent;
import score.Score;
import settings.GameSetting;
import ui.InputManager;
import ui.OutputManager;

import java.util.List;

public class BaseBallGame {

    private final Opponent opponent;

    public BaseBallGame(Opponent opponent) {
        this.opponent = opponent;
    }

    public void start() {
        Score score;
        do {
            score = nextStage();
        } while (!isGameOver(score));
        GameSetting.getInstance().getOutputManager().printGameOverMessage();
    }

    private boolean isGameOver(Score score) {
        return score.getStrikeCount() == 3;
    }

    private Score nextStage() {
        Score score = new Score(0, 0);
        OutputManager outputManager = GameSetting.getInstance().getOutputManager();
        InputManager inputManager = GameSetting.getInstance().getInputManager();
        outputManager.printInputMessage();
        List<Integer> inputNumbers = inputManager.getInputNumbers();
        for (int i = 0; i < inputNumbers.size(); i++) {
            score.updateScore(opponent.getAnswer(), inputNumbers.get(i), i);
        }
        outputManager.printResult(score);
        return score;
    }
}
