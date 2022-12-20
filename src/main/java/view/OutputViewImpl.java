package view;

import domain.JudgeResult;

public class OutputViewImpl implements OutputView {
    @Override
    public void printStrikeAndBall(JudgeResult judgeResult) {
        System.out.println(judgeResult.toString());
    }

    @Override
    public void printInputThreeNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void printGameResult() {
        System.out.println("3개의 숫자를 모두 맞히였습니다! 게임 종료");
    }

    @Override
    public void printInputGameOption() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려 2를 입력하세요.");
    }
}
