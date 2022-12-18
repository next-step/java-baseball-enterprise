package com.neurumaru.baseball;

public class BaseballGame extends RepeatedGame {

    private final GameIO gameIO;
    private final int digit;
    private final int restart_number;
    private final int quit_number;

    public BaseballGame(GameIO gameIO, int digit, int restart_number, int quit_number) {
        this.gameIO = gameIO;
        this.digit = digit;
        this.restart_number = restart_number;
        this.quit_number = quit_number;
    }

    @Override
    public void initGame() {}

    @Override
    public void startGame() {
        BaseballStage baseballStage = new BaseballStage(gameIO, digit);
        baseballStage.repeatGame();
    }

    @Override
    public void endGame() {}

    @Override
    public boolean isRepeated() {
        gameIO.println(BaseballData.RESTART_TAG, BaseballData.getRestartMap(restart_number, quit_number));
        int input = gameIO.input();
        while (!isValidInput(input)) {
            input = gameIO.input();
        }
        return input == restart_number;
    }

    public boolean isValidInput(int input) {
        return input == restart_number || input == quit_number;
    }
}
