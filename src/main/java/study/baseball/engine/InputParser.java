package study.baseball.engine;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public List<Integer> parseStringToIntegerList(String input) throws NumberFormatException {
        String[] inputArray = input.split("");
        List<Integer> result = new ArrayList<>();
        for (String number:inputArray) {
            result.add(Integer.parseInt(number));
        }
        if (input.length() != result.size()) {
            throw new RuntimeException("중복된 숫자가 존재합니다.");
        }
        return result;
    }
}
