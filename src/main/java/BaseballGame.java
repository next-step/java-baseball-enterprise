public class BaseballGame {
    UserInterface userInterface = new UserInterface();
    NumberGenerator numberGenerator = new NumberGenerator();
    int[] answerNumbers;

    public void start() {
        answerNumbers = numberGenerator.generate();
        String userInput = userInterface.getUserInput();
    }
}
