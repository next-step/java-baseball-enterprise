public class BaseballGame {
    NumberGenerator numberGenerator = new NumberGenerator();
    int[] answerNumbers;

    public void start() {
        answerNumbers = numberGenerator.generate();
    }
}
