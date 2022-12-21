package study.baseball;

import java.util.regex.Pattern;
import study.baseball.engine.Baseball;
import study.baseball.engine.InputParser;
import study.baseball.engine.InputValidator;
import study.baseball.engine.NumberGenerator;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        Pattern regex = Pattern.compile("[0-9]{3}");
        InputValidator validator = new InputValidator(regex);
        InputParser parser = new InputParser();
        NumberGenerator numberGenerator = new NumberGenerator();
        Baseball baseball = new Baseball(console, validator, parser, numberGenerator);

        baseball.run();
    }
}
