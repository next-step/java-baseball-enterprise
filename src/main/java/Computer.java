import constant.NumberConstant;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Computer {
    int number;

    public void initializeRandomNumber() {
        this.number = generateRandomNumberBetween(NumberConstant.MIN, NumberConstant.MAX);
    }

    private int generateRandomNumberBetween(int min, int max) {
        try {
            return SecureRandom.getInstanceStrong()
                    .nextInt(max + 1 - min) + min;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
