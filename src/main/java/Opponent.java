import java.util.List;
import java.util.Objects;
import utils.RandomUtil;

public class Opponent {

    private List<Integer> answer;

    List<Integer> setAnswer(int digit) {
        this.answer = RandomUtil.generateRandomNumbers(digit);
        return answer;
    }

    int countStrikes(List<Integer> guessNumber) {
        int strikes = 0;

        for (int i = 0; i < guessNumber.size(); ++i) {
            strikes += Objects.equals(answer.get(i), guessNumber.get(i)) ? 1 : 0;
        }

        return strikes;
    }

    int countBalls(List<Integer> guessNumber) {
        int balls = 0;

        for (int i = 0; i < guessNumber.size(); ++i) {
            int indexOfAnswer = answer.indexOf(guessNumber.get(i));
            balls += (indexOfAnswer != -1 && indexOfAnswer != i) ? 1 : 0;
        }

        return balls;
    }
}
