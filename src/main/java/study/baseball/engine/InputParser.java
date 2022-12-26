package study.baseball.engine;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class InputParser {
    public List<Integer> parseStringToIntegerList(String input) {
        String[] inputArray = input.split("");
        Set<Integer> result = new LinkedHashSet<>();
        for (String number : inputArray) {
            result.add(Integer.parseInt(number));
        }
        if (result.size() < 3) {
            throw new RuntimeException("중복된 숫자가 존재합니다.");
        }
        return new ArrayList<>(result);
    }
}
