package view;

import domain.JudgeResult;

public interface OutputView {
    void printStrikeAndBall(JudgeResult judgeResult);

    void printInputThreeNumber();

    void printGameResult();

    void printInputGameOption();
}
