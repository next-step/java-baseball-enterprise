package baseball;

import baseball.model.Judgements;
import baseball.model.Numbers;
import baseball.model.NumbersGenerator;
import baseball.model.Referee;
import baseball.view.Command;
import baseball.view.View;

public class BaseBallGames {

    private final View view;
    private final NumbersGenerator numbersGenerator;

    public BaseBallGames(View view, NumbersGenerator numbersGenerator) {
        this.view = view;
        this.numbersGenerator = numbersGenerator;
    }

    public void playGames() {
        Command command = Command.NEW_GAME;

        while (command.isNewGame()) {
            playGame();
            command = view.inputCommand();
        }
    }

    private void playGame() {
        Referee referee = new Referee(numbersGenerator.generate());
        Judgements judgements = Judgements.nothing();

        while (!judgements.isThreeStrike()) {
            Numbers inputNumbers = view.inputNumbers();
            judgements = referee.judge(inputNumbers);
            view.printJudgements(judgements);
        }
    }
}
