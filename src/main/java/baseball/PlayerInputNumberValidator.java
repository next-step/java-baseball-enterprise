package baseball;

import java.util.HashSet;
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
}
