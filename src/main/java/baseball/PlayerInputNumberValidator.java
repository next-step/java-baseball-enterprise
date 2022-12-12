package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerInputNumberValidator {

    public boolean validate(String playerInput) {
        if (!canParseToInteger(playerInput)) {
            return false;
        }
        int playerNum = Integer.parseInt(playerInput);
        //TODO: 다른 검증 알고리즘 추가
        return true;
    }

    private boolean canParseToInteger(String str) {
        try {
            Integer.parseInt(playerInput);
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
