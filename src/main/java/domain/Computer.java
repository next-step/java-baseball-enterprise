package domain;

import java.util.Random;

public class Computer {

    private final int MIN = 1;
    private final int MAX = 9;

    private final Random random;

    public Computer() {
        random = new Random();
    }

    public int generateRandomNumber() {
        return random.nextInt(MAX) + MIN;
    }

}
