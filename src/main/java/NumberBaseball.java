import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.InteractionUtil;
import utils.RandomUtil;

public class NumberBaseball {

    private List<Integer> answer;
    private final int digit = 3;

    private boolean isValidAnswer(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);

        return numSet.size() == numbers.size();
    }

    private boolean isValidGuess(String guess) {
        if (guess.length() != this.digit) {
            return false;
        }

        try {
            Integer.parseInt(guess);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
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
        int guessNumber = getGuess();
    }

    private int getGuess() {
        String guess;
        do {
            guess = InteractionUtil.getUserInput("번호를 입력해주세요:");
        } while (!isValidGuess(guess));

        return Integer.parseInt(guess);
    }

    public void init() {
        setAnswer();
        startGame();
    }
}
