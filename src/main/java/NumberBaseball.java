import java.util.List;
import utils.NumberUtil;

public class NumberBaseball {

    private final Opponent oppo = new Opponent();
    private final NumberBaseBallUI gameUI = new NumberBaseBallUI();
    private final Validator validator = new Validator();
    private final int digit = 3;

    private void startGame() {
        int strikes, balls;
        do {
            List<Integer> guessNumber = getValidGuess();
            strikes = oppo.countStrikes(guessNumber);
            balls = oppo.countBalls(guessNumber);
            gameUI.displayResult(strikes, balls);
        } while (strikes != 3);

        endGame();
    }

    private void endGame() {
        String endOption;
        do {
            endOption = gameUI.getEndOption();
        } while (!validator.isValidEndOption(endOption));

        if (endOption.equals("2")) {
            init();
        }
    }

    private List<Integer> getValidGuess() {
        String guess;
        do {
            guess = gameUI.getUserGuess();
        } while (!validator.isValidGuess(guess, digit));

        return NumberUtil.toNumberArray(guess);
    }

    public void init() {
        List<Integer> randomNumbers;
        do {
            randomNumbers = oppo.setAnswer(this.digit);
        } while (!validator.isValidAnswer(randomNumbers));
        
        startGame();
    }
}
