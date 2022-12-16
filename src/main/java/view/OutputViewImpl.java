package view;

import domain.JudgeResult;

public class OutputViewImpl implements OutputView {
    @Override
    public void printStrikeAndBall(JudgeResult judgeResult) {
        System.out.println(judgeResult.toString());
    }
}
