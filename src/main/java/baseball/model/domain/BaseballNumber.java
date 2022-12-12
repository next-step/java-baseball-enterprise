package baseball.model.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {

    private final int firstDigit;
    private final int secondDigit;
    private final int thirdDigit;

    public BaseballNumber(int firstDigit, int secondDigit, int thirdDigit) {
        validateIsSingleDigit(firstDigit);
        validateIsSingleDigit(secondDigit);
        validateIsSingleDigit(thirdDigit);
        validateIsNotDuplicate(firstDigit, secondDigit, thirdDigit);
        this.firstDigit = firstDigit;
        this.secondDigit = secondDigit;
        this.thirdDigit = thirdDigit;
    }

    private void validateIsSingleDigit(int digit) {
        if (0 > digit || 9 < digit) {
            throw new IllegalArgumentException("한 자리수의 digit 만 허락합니다");
        }
    }

    private void validateIsNotDuplicate(int firstDigit, int secondDigit, int thirdDigit) {
        Set<Integer> checkDuplicate = new HashSet<>(List.of(firstDigit, secondDigit, thirdDigit));
        if (checkDuplicate.size() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해주세요");
        }
    }

    public StrikeBallResult compare(BaseballNumber input) {
        StrikeBallResult firstDigitStrikeBallResult = calculateFirstDigit(input);
        StrikeBallResult secondDigitStrikeBallResult = calculateSecondDigit(input);
        StrikeBallResult thirdDigitStrikeBallResult = calculateThirdDigit(input);
        List<StrikeBallResult> strikeBallResults = List.of(firstDigitStrikeBallResult,
                secondDigitStrikeBallResult, thirdDigitStrikeBallResult);
        return StrikeBallResult.addAll(strikeBallResults);
    }

    private StrikeBallResult calculateFirstDigit(BaseballNumber input) {
        if (this.firstDigit == input.firstDigit) {
            return StrikeBallResult.of(1, 0);
        }
        if (this.firstDigit == input.secondDigit || this.firstDigit == input.thirdDigit) {
            return StrikeBallResult.of(0, 1);
        }
        return StrikeBallResult.of(0, 0);
    }

    private StrikeBallResult calculateSecondDigit(BaseballNumber input) {
        if (this.secondDigit == input.secondDigit) {
            return StrikeBallResult.of(1, 0);
        }
        if (this.secondDigit == input.firstDigit || this.secondDigit == input.thirdDigit) {
            return StrikeBallResult.of(0, 1);
        }
        return StrikeBallResult.of(0, 0);
    }

    private StrikeBallResult calculateThirdDigit(BaseballNumber input) {
        if (this.thirdDigit == input.thirdDigit) {
            return StrikeBallResult.of(1, 0);
        }
        if (this.thirdDigit == input.firstDigit || this.thirdDigit == input.secondDigit) {
            return StrikeBallResult.of(0, 1);
        }
        return StrikeBallResult.of(0, 0);
    }
}
