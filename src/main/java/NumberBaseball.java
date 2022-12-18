import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import utils.NumberUtil;
import utils.RandomUtil;

public class NumberBaseball {

    private List<Integer> answer;
    private final NumberBaseBallUI gameUI = new NumberBaseBallUI();
    private final int digit = 3;

    private boolean isValidAnswer(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);

        return numSet.size() == numbers.size();
    }

    private boolean isValidGuess(String guess) {
        return guess.length() == this.digit && NumberUtil.isNumber(guess);
    }

    private void setValidAnswer() {
        List<Integer> randomNumbers;
        do {
            randomNumbers = RandomUtil.generateRandomNumbers(digit);
        } while (!isValidAnswer(randomNumbers));

        this.answer = randomNumbers;
    }

    private void startGame() {
        int strikes, balls;
        do {
            List<Integer> guessNumber = getValidGuess();
            strikes = countStrikes(guessNumber);
            balls = countBalls(guessNumber);
            gameUI.displayResult(strikes, balls);
        } while (strikes != 3);

        endGame();
    }

    private void endGame() {
        String endOption;
        do {
            endOption = gameUI.getEndOption();
        } while (!endOption.equals("1") && !endOption.equals("2"));

        if (endOption.equals("2")) {
            init();
        }
    }

    private int countStrikes(List<Integer> guessNumber) {
        int strikes = 0;

        for (int i = 0; i < digit; ++i) {
            strikes += Objects.equals(answer.get(i), guessNumber.get(i)) ? 1 : 0;
        }

        return strikes;
    }

    private int countBalls(List<Integer> guessNumber) {
        int balls = 0;

        for (int i = 0; i < digit; ++i) {
            int indexOfAnswer = answer.indexOf(guessNumber.get(i));
            balls += (indexOfAnswer != -1 && indexOfAnswer != i) ? 1 : 0;
        }

        return balls;
    }

    private List<Integer> getValidGuess() {
        String guess;
        do {
            guess = gameUI.getUserGuess();
        } while (!isValidGuess(guess));

        return NumberUtil.toNumberArray(guess);
    }

    public void init() {
        setValidAnswer();
        startGame();
    }
}
