package baseball.controller;

import baseball.dto.BaseballResult;
import baseball.service.BaseballService;
import java.util.List;

public class BaseballController {

    BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    public BaseballResult getBaseballResult(List<Integer> userBaseballNumber) {
        Integer strikeCount = baseballService.getStrikeCount(userBaseballNumber);
        Integer ballCount = baseballService.getBallCount(userBaseballNumber);
        return new BaseballResult(strikeCount, ballCount);
    }

    public boolean isPlaying() {
        return baseballService.isPlaying();
    }

    public void startGame() {
        baseballService.startGame();
    }

    public void finishGame() {
        baseballService.finishGame();
    }

}
