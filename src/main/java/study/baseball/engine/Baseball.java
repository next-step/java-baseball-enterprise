package study.baseball.engine;

public class Baseball implements Runnable {
    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public Baseball(InputValidator inputValidator, InputParser inputParser) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }

    @Override
    public void run() {

    }
}
