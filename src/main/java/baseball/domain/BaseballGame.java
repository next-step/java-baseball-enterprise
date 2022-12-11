package baseball.domain;

public class BaseballGame {
    private final Judge judge;
    public BaseballGame(BaseballNumbers baseballNumbers) {
        judge = new Judge(baseballNumbers);
    }
    public StrikeBallCount getResult(BaseballNumbers userNumbers) {
        return judge.judge(userNumbers);
    }
}
