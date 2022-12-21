package ui;

import score.Score;

import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputManager {

    private final PrintWriter printWriter;

    public OutputManager(OutputStream os) {
        printWriter = new PrintWriter(os);
    }

    public void printResult(Score score) {
        if (score.getStrikeCount() == 0 && score.getBallCount() == 0) {
            printWriter.println("낫싱");
            return;
        }
        String strikeResultMessage = strikeCountToString(score.getStrikeCount());
        String ballResultMessage = ballCountToString(score.getBallCount());
        printWriter.println(strikeResultMessage + ballResultMessage);
    }

    private String strikeCountToString(int strikeCount) {
        if (strikeCount == 0) {
            return "";
        }
        return String.format("%d 스트라이크 ", strikeCount);
    }

    private String ballCountToString(int ballCount) {
        if (ballCount == 0) {
            return "";
        }
        return String.format("%d 볼 ", ballCount);
    }
}
