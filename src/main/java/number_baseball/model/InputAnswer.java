package number_baseball.model;

import global.exceptions.IllegalGameArgumentException;
import lombok.Getter;
import number_baseball.enums.GameSettings;

@Getter
public class InputAnswer {

    private final String number;

    public InputAnswer(String number) throws IllegalArgumentException {
        if (number == null || number.length() != GameSettings.MAX_LENGTH || !isValidNumber(number)) {
            throw new IllegalGameArgumentException(
                    String.format("숫자는 1부터 9까지 서로 다른 %d자리 수로 이루어져야 합니다.", GameSettings.MAX_LENGTH));
        }

        this.number = number;
    }

    private boolean isValidNumber(String number) {
        if (number.charAt(0) < '1' || number.charAt(0) > '9') {
            return false;
        }

        if (number.length() == 1) {
            return true;
        }

        String remained = number.substring(1);

        return !remained.contains(String.valueOf(number.charAt(0))) && isValidNumber(remained);
    }
}
