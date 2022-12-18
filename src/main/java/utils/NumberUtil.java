package utils;

import java.util.ArrayList;
import java.util.List;

public class NumberUtil {

    public static boolean isNumber(String possibleNumber) {
        try {
            Integer.parseInt(possibleNumber);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    public static List<Integer> toNumberArray(String number) {
        List<Integer> arr = new ArrayList<>(number.length());

        for (int i = 0; i < number.length(); ++i) {
            arr.add(i, number.charAt(i) - '0');
        }

        return arr;
    }
}
