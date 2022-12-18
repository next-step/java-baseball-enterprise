import java.util.List;
import utils.RandomUtil;

public class NumberBaseball {

    private List<Integer> answer;

    public void start() {
        int digit = 3;
        this.answer = RandomUtil.generateRandomNumbers(digit);
    }
}
