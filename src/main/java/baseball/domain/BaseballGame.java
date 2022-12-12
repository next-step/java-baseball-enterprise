package baseball.domain;

public class BaseballGame {
    private final Referee referee;
    public BaseballGame(BaseballNumbers baseballNumbers) {
        referee = new Referee(baseballNumbers);
    }
    public StrikeBallCount getResult(BaseballNumbers userNumbers) {
        return referee.judge(userNumbers);
    }
}
