public class BaseballGame {
    UserInterface userInterface = new UserInterface();
    NumberGenerator numberGenerator = new NumberGenerator();
    Judgement judgement = new Judgement();
    int[] answerNumbers;

    public void start() {
        answerNumbers = numberGenerator.generate();
        String userInput = userInterface.getUserInput();
        JudgementResult judgementResult = judgement.judge(answerNumbers, userInput);
    }
}
