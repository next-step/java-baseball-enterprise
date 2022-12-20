import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Computer {
    private Integer[] numbers = new Integer[3];

    Computer() {
        resetRandomNumbers();
    }

    public Integer[] getNumbers() {
        return numbers;
    }

    public void resetRandomNumbers() {
        numbers = getThreeUniqueRandomNumbers();
    }
    public Integer[] getThreeUniqueRandomNumbers() {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < 3) {
            Double d = Math.random() * 9 + 1;
            numberSet.add(d.intValue());
        }
        Integer[] randomNumbers = numberSet.toArray(new Integer[0]);
        Collections.shuffle(Arrays.asList(randomNumbers));
        return randomNumbers;
    }

    public int[] calculateScores(Integer[] playerNumbers) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            strikeCount += checkStrike(i, playerNumbers[i]);
            ballCount += checkBall(i, playerNumbers[i]);
        }
        return new int[] {strikeCount, ballCount};
    }

    public int checkStrike(int idx, Integer number) {
        return number.equals(numbers[idx]) ? 1 : 0;
    }

    public int checkBall(int idx, Integer playerNumbers) {
        if (numbers[(idx+1)%3].equals(playerNumbers)) return 1;
        if (numbers[(idx+2)%3].equals(playerNumbers)) return 1;
        return 0;
    }
}
