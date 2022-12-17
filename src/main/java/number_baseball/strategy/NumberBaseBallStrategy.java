package number_baseball.strategy;

import number_baseball.model.GameResult;
import number_baseball.model.InputAnswer;

public interface NumberBaseBallStrategy {

    InputAnswer offerNumber();

    GameResult verifyAnswer(String dst, String src);
}
