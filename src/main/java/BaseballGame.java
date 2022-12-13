public class BaseballGame {
    UserInterface userInterface = new UserInterface();
    NumberGenerator numberGenerator = new NumberGenerator();
    Judgement judgement = new Judgement();
    int[] answerNumbers;

    public void start() {
        answerNumbers = numberGenerator.generate();
        judgeUserInput();
    }

    private void judgeUserInput() {
        String userInput = userInterface.getUserInput();
        JudgementResult judgementResult = judgement.judge(answerNumbers, userInput);
        userInterface.printResult(judgementResult);
        if (judgementResult.strikes < 3) {
            judgeUserInput();
            return;
        }
        end();
    }

    private void end() {
        userInterface.printGameFinished();
        if (userInterface.isRestartGame()) {
            start();
            return;
        }
        userInterface.printExit();
    }
}
