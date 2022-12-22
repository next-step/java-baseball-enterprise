package domain.number_baseball.controller;

import domain.number_baseball.common.NumberBaseballSetting;
import domain.number_baseball.model.ComputerStrategy;
import domain.number_baseball.model.NumberBaseballOpponentStrategy;
import domain.number_baseball.view.NumberBaseballView;
import global.controller.GameController;
import global.model.InputVerifier;

public final class NumberBaseballGameController implements GameController {
    final private NumberBaseballView view;
    final private NumberBaseballOpponentStrategy opponent;

    public NumberBaseballGameController(NumberBaseballView view) {
        this.view = view;
        this.opponent = new ComputerStrategy();
    }

    @Override
    public void run() {
        opponent.setAnswer();

        boolean success = false;
        while(!success) {
            String input = view.getInputStringFromPlayer();
            view.printResult(opponent.countStrikeScore(input), opponent.countBallScore(input));
            success = opponent.isAnswer(input);
        }
        view.finishSingleGame();
    }

    @Override
    public boolean isWillingToReplayingGame() {
        String userInput = view.getInputFromPlayerForReplaying();

        while(!userInput.equals(NumberBaseballSetting.TRUE_INPUT)
                && !userInput.equals(NumberBaseballSetting.FALSE_INPUT)) {
            view.printWrongInputMessage();
            userInput = view.getInputFromPlayerForReplaying();
        }

        return userInput.equals(NumberBaseballSetting.TRUE_INPUT);
    }

    @Override
    public void quitGame() {
        view.finishEntireGame();
    }
}
