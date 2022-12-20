import constant.NumberConstant;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import static constant.NumberConstant.MAX;

public class Computer {
    int number;

    public void initializeRandomNumber() {
        this.number = generateRandomNumberBetween(NumberConstant.MIN, NumberConstant.MAX);
    }

    private int generateRandomNumberBetween(int min, int max) {
        try {
            Random rand = SecureRandom.getInstanceStrong();
            return rand.nextInt(max + 1 - min) + min;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
