package number_baseball.strategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import number_baseball.enums.GameSettings;
import number_baseball.model.GameResult;
import number_baseball.model.InputAnswer;

public class ComputerPlayStrategy implements NumberBaseBallStrategy {

    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Override
    public InputAnswer offerNumber() {
        StringBuilder number = new StringBuilder();
        List<Integer> shuffledNumbers = getShuffledNumbers();
        for (int i = 0; i < GameSettings.MAX_LENGTH; i++) {
            number.append(shuffledNumbers.get(i));
        }

        return new InputAnswer(number.toString());
    }

    private List<Integer> getShuffledNumbers() {
        List<Integer> numberList = Arrays.asList(numbers);
        Collections.shuffle(numberList);

        return numberList;
    }

    @Override
    public GameResult verifyAnswer(String dst, String src) {

        return GameResult.builder()
                .strike(countStrike(dst, src))
                .ball(countBall(dst, src, 0))
                .build()
                ;
    }

    private int countStrike(String dst, String src) {
        int count = 0;
        for (int i = 0; i < dst.length(); i++) {
            count += dst.charAt(i) == src.charAt(i) ? 1 : 0;
        }

        return count;
    }

    private int countBall(String dst, String src, int index) {
        if (index >= dst.length()) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < dst.length(); i++) {
            count += dst.charAt(index) == src.charAt(i) && i != index ? 1 : 0;
        }

        return countBall(dst, src, index + 1) + count;
    }
}
