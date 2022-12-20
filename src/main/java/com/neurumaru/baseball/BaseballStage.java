package com.neurumaru.baseball;

public class BaseballStage extends RepeatedGame {
    private final GameIO gameIO;
    private final int digit;
    private BaseballNumbers computerBaseballNumbers;
    private BaseballScore baseballScore;

    public BaseballStage(GameIO gameIO, int digit) {
        this.gameIO = gameIO;
        this.digit = digit;
    }

    @Override
    public void initGame() {
        computerBaseballNumbers = new BaseballNumbers(digit);
    }

    @Override
    public void startGame() {
        gameIO.print(BaseballData.REQUEST_INPUT_NUMBER_TAG);
        BaseballStageInputValidator validator = new BaseballStageInputValidator(digit);
        baseballScore = getBaseballScore(gameIO.inputValid(validator));
        printScore(baseballScore);

    }

    private BaseballScore getBaseballScore(int numbers) {
        BaseballNumbers playerBaseballNumbers = new BaseballNumbers(digit, numbers);
        return new BaseballScore(playerBaseballNumbers, computerBaseballNumbers);
    }

    private void printScore(BaseballScore score) {
        printStrike(score);
        printBall(score);
        printNothing(score);
        gameIO.println();
    }

    private void printStrike(BaseballScore score) {
        if (score.getStrike() != 0) {
            gameIO.print(BaseballData.STRIKE_TAG, BaseballData.getStrikeMap(score.getStrike()));
        }
    }

    private void printBall(BaseballScore score) {
        if (score.getBall() != 0) {
            gameIO.print(BaseballData.BALL_TAG, BaseballData.getBallMap(score.getBall()));
        }
    }

    private void printNothing(BaseballScore score) {
        if (score.getStrike() == 0 && score.getBall() == 0) {
            gameIO.print(BaseballData.NOTHING_TAG);
        }
    }

    @Override
    public void endGame() {
        gameIO.println(BaseballData.GAME_TERMINATION_TAG, BaseballData.getGameTerminationMap(digit));
    }

    @Override
    public boolean isRepeated() {
        return baseballScore.getStrike() != digit;
    }
}
