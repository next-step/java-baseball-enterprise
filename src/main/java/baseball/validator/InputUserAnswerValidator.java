package baseball.validator;

import baseball.constant.Constant;
import baseball.domain.BaseballNumbers;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

public class InputUserAnswerValidator extends Validator {
    private static final int MIN = Constant.MIN_RANGE.getValue();
    private static final int MAX = Constant.MAX_RANGE.getValue();
    private static final int LENGTH = Constant.LENGTH.getValue();
    private static final String REGEX_ERROR_MESSAGE_FORMAT = "[ERROR] 형식에 맞게 입력하세요 : 중복이 없는 %d과 %d 사이의 %d자리 수";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복이 없어야 합니다.";

    private static final String ANSWER_REGEX = String.format("^[%d-%d]{%d}$", MIN, MAX, LENGTH);
    public static BaseballNumbers validate(String inputAnswer) {
        String trimmedInput = removeSpace(inputAnswer);
        if (Pattern.matches(ANSWER_REGEX, trimmedInput)){
            return validateUniqueness(trimmedInput);
        }
        throw new IllegalArgumentException(String.format(REGEX_ERROR_MESSAGE_FORMAT, MIN, MAX, LENGTH));
    }

    public static BaseballNumbers validateUniqueness(String input){
        if (new HashSet<>(Arrays.asList(input.split(""))).size() == input.length()){
            return new BaseballNumbers(input.split(""));
        }
        throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
    }
}
