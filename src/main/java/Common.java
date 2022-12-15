import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {

    public static boolean validation(String input){
        if(!input.matches("[1-9]{3}"))
            return false;

        char[] arr = input.toCharArray();
        Arrays.sort(arr);
        String temp = String.valueOf(arr);

        Matcher matcher = Pattern.compile("(\\d)\\1").matcher(temp);
        return !matcher.find();
    }

    public static void setPositionNumber(String number, HashMap<Character, Integer> hashMap) {
        for(int i = 0; i < number.length(); i++){
            hashMap.put(number.charAt(i), i);
        }
    }
}

