package baseball;

import baseball.model.Judgements;
import baseball.model.Numbers;
import baseball.model.Referee;
import baseball.view.Command;
import baseball.view.View;

public class BaseBallGame {

    private final Numbers rightNumbers;
    private final View view;

    public BaseBallGame(View view, String numbers) {
        this.view = view;
        this.rightNumbers = Numbers.from(numbers);
    }

    public void run() {
        Referee referee = new Referee(rightNumbers);
        boolean isContinue = true;

        while (isContinue) {
            Numbers inputNumbers = view.inputNumbers();
            Judgements judgements = referee.judge(inputNumbers);
            view.printJudgements(judgements);
            isContinue = isContinueBy(judgements);
        }
    }

    private boolean isContinueBy(Judgements judgements) {
        if (judgements.isThreeStrike()) {
            Command command = view.inputCommand();
            return command.isNewGame();
        }
        return true;
    }
}
