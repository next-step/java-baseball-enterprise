package ui;

import score.Score;

public class OutputManager {

    public void printResult(Score score) {
        if (score.getStrikeCount() == 0 && score.getBallCount() == 0) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(score.strikeCountToString() + score.ballCountToString());
    }
}
