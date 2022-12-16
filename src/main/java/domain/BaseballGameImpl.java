package domain;

import config.BaseballConfig;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameImpl extends BaseballGame {


    public BaseballGameImpl(BaseballConfig baseballConfig) {
        super(baseballConfig);

    }

    @Override
    public void play(int option) {
        if (option == 2)
            return;
        List<Integer> answer = threeNumberGenerator.generate();
        List<Integer> inputNumbers;
        JudgeResult judgeResult = new JudgeResult(0, 0);
        do {
            inputNumbers = this.inputView.getThreeNumbers();
            JudgeResult judge = baseballReferee.judge(answer, inputNumbers);
            judgeResult.change(judge.getStrikesNum(), judge.getBallNum());
        } while (judgeResult.getStrikesNum() != 3);
        play(inputView.readOneNumber());
    }
}
