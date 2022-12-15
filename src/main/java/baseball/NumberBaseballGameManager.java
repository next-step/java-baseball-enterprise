package baseball;

import baseball.dto.StrikeBallCountDto;

import java.io.IOException;
import java.util.List;

public class NumberBaseballGameManager {
    private final RandomBaseballNumberGenerator randomBaseballNumberGenerator;
    private final StrikeBallCounter strikeBallCounter;
    private final NumberBaseballUi numberBaseballUi;

    public NumberBaseballGameManager() {
        randomBaseballNumberGenerator = new RandomBaseballNumberGenerator();
        strikeBallCounter = new StrikeBallCounter();
        numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());
    }

    public void close() throws IOException {
        numberBaseballUi.close();
    }

    public boolean playGame() throws IOException {
        List<Integer> computerBaseballNumber = randomBaseballNumberGenerator.generateRandomBaseballNumber();
        int strikeCount = 0;
        while (strikeCount != 3) {
            List<Integer> playerBaseballNumber = numberBaseballUi.readPlayerBaseballNumber();
            StrikeBallCountDto strikeBallCount =
                    strikeBallCounter.countStrikeAndBall(computerBaseballNumber, playerBaseballNumber);
            numberBaseballUi.printStrikeBallCount(strikeBallCount);
            strikeCount = strikeBallCount.getStrikeCnt();
        }
        return numberBaseballUi.readGameRestartInput() == 1;
    }
}
