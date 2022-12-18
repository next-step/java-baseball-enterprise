package com.neurumaru.baseball;

public class BaseballStage extends RepeatedGame {
    private final GameUI gameUI;
    private final int digit;
    private BaseballNumbers computerBaseballNumbers;
    private BaseballScore baseballScore;

    public BaseballStage(GameUI gameUI, int digit) {
        this.gameUI = gameUI;
        this.digit = digit;
    }

    @Override
    public void initGame() {
        computerBaseballNumbers = new BaseballNumbers(digit);
    }

    @Override
    public void startGame() {
        gameUI.print(BaseballData.REQUEST_INPUT_NUMBER_TAG);
        baseballScore = getBaseballScore(inputValid());
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
        gameUI.println();
    }

    private void printStrike(BaseballScore score) {
        if (score.getStrike() != 0) {
            gameUI.print(BaseballData.STRIKE_TAG, BaseballData.getStrikeMap(score.getStrike()));
        }
    }

    private void printBall(BaseballScore score) {
        if (score.getBall() != 0) {
            gameUI.print(BaseballData.BALL_TAG, BaseballData.getBallMap(score.getBall()));
        }
    }

    private void printNothing(BaseballScore score) {
        if (score.getStrike() == 0 && score.getBall() == 0) {
            gameUI.print(BaseballData.NOTHING_TAG);
        }
    }

    @Override
    public void endGame() {
        gameUI.println(BaseballData.GAME_TERMINATION_TAG, BaseballData.getGameTerminationMap(digit));
    }

    @Override
    public boolean isRepeated() {
        return baseballScore.getStrike() != digit;
    }

    public int inputValid() {
        int input = gameUI.input();
        while (isValidInput(input)) {
            input = gameUI.input();
        }
        return input;
    }

    public boolean isValidInput(int input) {
        return Math.log10(input) + 1 == digit;
    }
}
