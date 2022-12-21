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

    public void checkValidFormat(String input) {
        if(!regex.matcher(input).matches()) {
            throw new RuntimeException("입력의 형식이 잘못되었습니다.");
        }
    }
}
