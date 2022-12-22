package baseball;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Pitcher {
    public String generateNumber() {
        Random random = new Random();
        ArrayList<Integer> digits = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(digits.size());
            number.append(digits.get(randomIndex));
            digits.remove(randomIndex);
        }
        return number.toString();
    }
}
