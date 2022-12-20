import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.NumberUtil;

public class Validator {

    boolean isValidAnswer(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);

        return numSet.size() == numbers.size();
    }

    boolean isValidGuess(String guess, int digit) {
        return guess.length() == digit && NumberUtil.isNumber(guess);
    }

    boolean isValidEndOption(String endOption) {
        return endOption.equals("1") || endOption.equals("2");
    }
}
