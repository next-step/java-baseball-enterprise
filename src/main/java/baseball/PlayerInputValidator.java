package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerInputValidator {

    public boolean validateBaseballNumber(String playerInput) {
        if (playerInput == null || !canParseToInteger(playerInput)) {
            return false;
        }
        int playerNum = Integer.parseInt(playerInput);
        if (!is3DigitPositiveNumber(playerNum)) {
            return false;
        }
        List<Integer> digits = extractDigits(playerNum);
        return !digits.contains(0) && hasUniqueDigit(digits);
    }

    public boolean validateRestartInput(String playerInput) {
        if (!canParseToInteger(playerInput)) {
            return false;
        }
        int restartInput = Integer.parseInt(playerInput);
        return restartInput == 1 || restartInput == 2;
    }

    private boolean canParseToInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
        return true;
    }

    private boolean is3DigitPositiveNumber(int num) {
        return num >= 100 && num <= 999;
    }

    private List<Integer> extractDigits(int num) {
        List<Integer> digits = new ArrayList<>();
        if (num == 0) {
            digits.add(0);
        }
        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits;
    }

    private boolean hasUniqueDigit(List<Integer> digits) {
        Set<Integer> uniqueDigits = new HashSet<>(digits);
        return digits.size() == uniqueDigits.size();
    }
}
