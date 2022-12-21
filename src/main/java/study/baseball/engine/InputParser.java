package study.baseball.engine;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public List<Integer> parseStringToIntegerList(String input) {
        String[] inputArray = input.split("");
        List<Integer> result = new ArrayList<>();
        for (String number:inputArray) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }
}
