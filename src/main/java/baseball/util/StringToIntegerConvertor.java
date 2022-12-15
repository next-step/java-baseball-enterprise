package baseball.util;

public class StringToIntegerConvertor {
    public static int convert(String str) {
        try {
            return tryConvert(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자열이 숫자가 아닙니다.", e);
        }
    }

    private static int tryConvert(String str) {
        return Integer.parseInt(str);
    }
}
