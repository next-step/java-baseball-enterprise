package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {

    public static List<Integer> generateRandomNumbers(int length) {
        Random random = new Random();
        List<Integer> arr = new ArrayList<>(length);

        for (int i = 0; i < length; ++i) {
            arr.add(random.nextInt(9) + 1);
        }

        return arr;
    }
}
