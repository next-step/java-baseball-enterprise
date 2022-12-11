package baseball.controller.response;

import baseball.model.domain.StrikeBallResult;

public class GameResponse {

    private final int strike;
    private final int ball;
    private final boolean isPlaying;

    public GameResponse(int strike, int ball, boolean isPlaying) {
        this.strike = strike;
        this.ball = ball;
        this.isPlaying = isPlaying;
    }

    public static GameResponse of(StrikeBallResult strikeBallResult, boolean isPlaying) {
        return new GameResponse(strikeBallResult.getStrike(), strikeBallResult.getBall(), isPlaying);
    }
}
