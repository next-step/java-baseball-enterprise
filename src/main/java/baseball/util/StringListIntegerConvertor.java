package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class StringListIntegerConvertor {
    public static List<Integer> convert(String str) {
        try {
            return tryConvert(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자열이 숫자가 아닙니다.", e);
        }
    }

    private static List<Integer> tryConvert(String str) {
        List<Integer> list = new ArrayList<>();
        for (String digit : str.split("")) {
            list.add(Integer.parseInt(digit));
        }
        return list;
    }
}
