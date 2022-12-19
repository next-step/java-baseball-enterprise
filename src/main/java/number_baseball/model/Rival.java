package number_baseball.model;

import number_baseball.strategy.NumberBaseBallStrategy;

public class Rival extends Player {

    private final NumberBaseBallStrategy gameStrategy;

    private final String randomNumber;

    public Rival(NumberBaseBallStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
        this.randomNumber = this.gameStrategy.offerNumber().getNumber();
    }

    public GameResult verifyAnswer(InputAnswer input) {

        return gameStrategy.verifyAnswer(randomNumber, input.getNumber());
    }
}
