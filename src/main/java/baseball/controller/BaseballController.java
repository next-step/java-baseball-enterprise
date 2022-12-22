package baseball.controller;

import baseball.dto.BaseballResultDto;
import baseball.service.BaseballService;
import java.util.List;

public class BaseballController {

    BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    public BaseballResultDto getBaseballResult(List<Integer> userBaseballNumber) {
        Integer strikeCount = baseballService.getStrikeCount(userBaseballNumber);
        Integer ballCount = baseballService.getBallCount(userBaseballNumber);
        return new BaseballResultDto(strikeCount, ballCount);
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
