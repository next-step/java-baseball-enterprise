import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.RandomUtil;

public class NumberBaseball {

    private List<Integer> answer;
    private final int digit = 3;

    private boolean isValidAnswer(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);

        return numSet.size() == numbers.size();
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

    public void start() {
        setAnswer();
    }
}
