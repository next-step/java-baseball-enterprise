package domain;

import config.BaseballConfig;

import java.util.List;

public class BaseballGameImpl extends BaseballGame {
    List<Integer> answer;
    List<Integer> inputNumbers;


    public BaseballGameImpl(BaseballConfig baseballConfig) {
        super(baseballConfig);

    }

    @Override
    public void play(int option) {
        if (option == 2)
            return;
        answer = threeNumberGenerator.generate();
        JudgeResult judgeResult;
        do {
            inputNumbers = readThreeNumber();
            judgeResult = judgeAndPrint(answer, inputNumbers);
        } while (judgeResult.getStrikesNum() != 3);
        gameEnd();
    }

    private JudgeResult judgeAndPrint(List<Integer> answer, List<Integer> inputNumbers) {
        JudgeResult judgeResult;
        judgeResult = baseballReferee.judge(answer, inputNumbers);
        outputView.printStrikeAndBall(judgeResult);
        return judgeResult;
    }

    private void gameEnd() {
        outputView.printGameResult();
        outputView.printInputGameOption();
        play(inputView.readOneNumber());
    }

    private List<Integer> readThreeNumber() {
        List<Integer> inputNumbers;
        outputView.printInputThreeNumber();
        inputNumbers = this.inputView.readThreeNumber();
        return inputNumbers;
    }
}
