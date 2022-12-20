package study.baseball.engine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidator {

    private final Pattern regex;

    public InputValidator(Pattern regex) {
        this.regex = regex;
    }

    public boolean isValidFormat(String input) {
        return regex.matcher(input).matches();
    }

    public boolean hasDuplicateNumber(List<Integer> input) {
        Set<Integer> inputSet = new HashSet<Integer>(input);
        return input.size() == inputSet.size();
    }
}
