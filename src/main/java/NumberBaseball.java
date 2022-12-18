import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import utils.InteractionUtil;
import utils.NumberUtil;
import utils.RandomUtil;

public class NumberBaseball {

    private List<Integer> answer;
    private final int digit = 3;

    private boolean isValidAnswer(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);

        return numSet.size() == numbers.size();
    }

    private boolean isValidGuess(String guess) {
        return guess.length() == this.digit && NumberUtil.isNumber(guess);
    }

    private void setAnswer() {
        List<Integer> randomNumbers;
        do {
            randomNumbers = RandomUtil.generateRandomNumbers(digit);
            randomNumbers.forEach(System.out::println);
            System.out.println();
        } while (!isValidAnswer(randomNumbers));

        this.answer = randomNumbers;
    }

    private void startGame() {
        List<Integer> guessNumber = getGuess();
        List<Integer> result = calculateResult(guessNumber);
    }

    private List<Integer> calculateResult(List<Integer> guessNumber) {
        List<Integer> result = new ArrayList<>(2);

        result.add(countStrikes(guessNumber));
        result.add(countBalls(guessNumber));

        return result;
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

    private List<Integer> getGuess() {
        String guess;
        do {
            guess = InteractionUtil.getUserInput("번호를 입력해주세요:");
        } while (!isValidGuess(guess));

        return NumberUtil.toNumberArray(guess);
    }

    public void init() {
        setAnswer();
        startGame();
    }
}
