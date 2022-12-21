package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberGenerater {

    public static List<Integer> generate() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(integers);
        return integers.subList(0, 3);
    }
}
