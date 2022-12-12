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
    private static final String ANSWER_REGEX = String.format("^[%d-%d]{%d}$", MIN, MAX, LENGTH);
    public static BaseballNumbers validate(String inputAnswer) {
        String trimmedInput = removeSpace(inputAnswer);
        if (Pattern.matches(ANSWER_REGEX, trimmedInput)){
            return validateUniqueness(trimmedInput);
        }
        throw new IllegalArgumentException();
    }

    public static BaseballNumbers validateUniqueness(String input){
        if (new HashSet<>(Arrays.asList(input.split(""))).size() == input.length()){
            return new BaseballNumbers(input.split(""));
        }
        throw new IllegalArgumentException();
    }
}
