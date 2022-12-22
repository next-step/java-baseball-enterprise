package baseball.domain;

import baseball.constant.Constant;

public class Referee {
    private final BaseballNumbers answer;
    private final StrikeBallCount strikeBallCount;
    private final int length = Constant.LENGTH.getValue();

    public Referee(BaseballNumbers answer) {
        this.answer = answer;
        this.strikeBallCount = new StrikeBallCount();
    }

    public StrikeBallCount judge(BaseballNumbers userNumbers) {
        strikeBallCount.resetCounts();
        for (int index = 0; index < length; index++) {
            int number = userNumbers.getNumberAt(index);
            judgeOneNumber(index, number);
        }
        return strikeBallCount;
    }

    private void judgeOneNumber(int index, int number) {
        if (answer.contains(number)) {
            changeCount(index, number);
        }
    }

    private void changeCount(int index, int number) {
        if (index == answer.getIndex(number)) {
            strikeBallCount.addStrikeCount();
            return;
        }
        strikeBallCount.addBallCount();
    }
}
