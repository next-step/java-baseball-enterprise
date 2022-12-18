package utils;

public class NumberUtil {

    public static boolean isNumber(String possibleNumber) {
        try {
            Integer.parseInt(possibleNumber);
        } catch (NumberFormatException nfe) {
            return false;
        }
        
        return true;
    }
}
