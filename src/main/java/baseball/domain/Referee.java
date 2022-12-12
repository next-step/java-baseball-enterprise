package baseball.domain;

public class Referee {
    private final BaseballNumbers answer;
    private final StrikeBallCount strikeBallCount;
    public Referee(BaseballNumbers answer) {
        this.answer = answer;
        this.strikeBallCount = new StrikeBallCount();
    }

    public StrikeBallCount judge(BaseballNumbers userNumbers) {
        strikeBallCount.resetCounts();
        //구현 필요//
        return strikeBallCount;
    }
}
