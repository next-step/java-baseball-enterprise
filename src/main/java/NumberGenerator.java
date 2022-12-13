import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {
    private Set<Integer> includedNumbers = new HashSet<>();

    private void initialize() {
        includedNumbers.clear();
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private int getRandomNumberWithoutDuplicate() {
        int randomNumber = getRandomNumber();
        if (includedNumbers.contains(randomNumber)) {
            return getRandomNumberWithoutDuplicate();
        }
        includedNumbers.add(randomNumber);
        return randomNumber;
    }

    public int[] generate() {
        int[] randomNumbers = new int[3];
        initialize();

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = getRandomNumberWithoutDuplicate();
        }
        return randomNumbers;
    }
}
