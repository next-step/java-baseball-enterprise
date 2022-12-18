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
        int strikes, balls;
        do {
            List<Integer> guessNumber = getGuess();
            strikes = countStrikes(guessNumber);
            balls = countBalls(guessNumber);
            displayResult(strikes, balls);
        } while (strikes != 3);
    }

    private void displayResult(int strikes, int balls) {
        StringBuilder message = new StringBuilder();
        if (strikes == 0 && balls == 0) {
            message.append("낫싱");
        }
        if (strikes > 0) {
            message.append(strikes).append(" 스트라이크 ");
        }
        if (balls > 0) {
            message.append(balls).append(" 볼");
        }
        System.out.println(message);
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
