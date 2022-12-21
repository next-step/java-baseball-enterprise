package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreeNumberGeneratorImpl implements ThreeNumberGenerator {
    @Override
    public List<Integer> generate() {
        List<Integer> randomThreeNumber = new ArrayList<>();
        while (randomThreeNumber.size() < 3) {
            Integer randomNumber = getRandomNumber();
            add(randomNumber, randomThreeNumber);
        }
        return randomThreeNumber;
    }

    private boolean validate(int num, List<Integer> threeNumber) {
        return !threeNumber.contains(num);
    }

    private void add(int num, List<Integer> threeNumber) {
        if (validate(num, threeNumber)) {
            threeNumber.add(num);
        }
    }

    private Integer getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }
}
