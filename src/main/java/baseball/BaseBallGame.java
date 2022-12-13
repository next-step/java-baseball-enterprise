package baseball;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BaseBallGame {

    private final PrintStream printStream;
    private final Scanner scanner;
    private final Numbers rightNumbers;

    public BaseBallGame(PrintStream printStream, InputStream inputStream, String numbers) {
        this.printStream = printStream;
        this.scanner = new Scanner(inputStream);
        this.rightNumbers = Numbers.from(numbers);
    }

    public void run() {
        Referee referee = new Referee(rightNumbers);
        boolean isContinue = true;

        while (isContinue) {
            Numbers inputNumbers = inputNumbers();

            Judgements judgements = referee.judge(inputNumbers);

            printJudgements(judgements);

            isContinue = isContinue(judgements);
        }
    }

    private boolean isContinue(Judgements judgements) {
        if (judgements.isThreeStrike()) {
            printStream.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            printStream.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String isContinue = scanner.next();
            return isContinue.equals("1");
        }
        return true;
    }

    private Numbers inputNumbers() {
        printStream.println("숫자를 입력하세요 : ");
        String inputNumbersText = scanner.next();
        return Numbers.from(inputNumbersText);
    }

    private void printJudgements(Judgements judgements) {
        String text = judgementsText(judgements);
        printStream.println(text);
    }

    private String judgementsText(Judgements judgements) {
        if (judgements.isNothing()) {
            return nothingText();
        }
        return strikeText(judgements) + ballText(judgements);
    }

    private String nothingText() {
        return "낫싱";
    }

    private String strikeText(Judgements judgements) {
        if (judgements.getStrike() == 0) {
            return "";
        }
        return judgements.getStrike() + "스트라이크";
    }

    private String ballText(Judgements judgements) {
        if (judgements.getBall() == 0) {
            return "";
        }
        if (judgements.getStrike() != 0) {
            return " " + judgements.getBall() + "볼";
        }
        return judgements.getBall() + "볼";
    }
}
