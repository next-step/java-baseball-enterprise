package baseball.IO;

import baseball.dto.GuessResult;

public class SystemOutputPrinter implements OutputPrinter {

    @Override
    public void printInputGuideMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void printResult(GuessResult result) {
        System.out.println(result.toString());
    }

    @Override
    public void printClearMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
