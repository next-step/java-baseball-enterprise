package ui;

import score.Score;

import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputManager {

    private final PrintWriter printWriter;

    public OutputManager(OutputStream os) {
        printWriter = new PrintWriter(os);
    }

    public void printInputMessage() {
        printWriter.print("숫자를 입력해주세요 : ");
    }

    public void printGameOverMessage() {
        printWriter.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        printWriter.println("게임을 새로 시작하려면 1, 종료하려 2를 입력하세요.");
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
