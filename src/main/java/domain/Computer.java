package domain;

import java.util.*;

public class Computer {

    private static final int MIN = 1;
    private static final int MAX = 9;

    private final Random random;

    public Computer() {
        random = new Random();
    }

    public String generateThreeDifferentNumber() {
        Set<Integer> set = new HashSet<>();

        while (set.size() < 3) {
            set.add(generateRandomNumber());
        }

        return set.toString()
                .replaceAll("[^0-9]", "");
    }

    public int generateRandomNumber() {
        return random.nextInt(MAX) + MIN;
    }

}
