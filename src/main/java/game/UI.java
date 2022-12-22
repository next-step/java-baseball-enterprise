package game;

import java.util.Scanner;
import java.util.HashSet;

public class UI {
    private GameRule gameRule;
    private Scanner scanner;

    public UI(GameRule gameRule) {
        this.gameRule = gameRule;
        this.scanner = new Scanner(System.in);
    }

    private boolean verifyNumbersLength(String input) {
        return input.length() == gameRule.numbersLengh;
    }

    private boolean verifyNumbersRangeOfLetter(int letter) {
        boolean isInRange = false;
        for (int num : gameRule.numbersRange) {
            isInRange = isInRange || letter == num;
        }
        return isInRange;
    }

    private boolean verifyNumbersRange(String input) {
        boolean isCorrect = true;
        for (int i = 0; i < gameRule.numbersLengh; i++) {
            isCorrect = isCorrect && this.verifyNumbersRangeOfLetter(input.charAt(i) - '0');
        }
        return isCorrect;
    }

    private boolean verifyNumbersDuplication(String input) {
        boolean isCorrect = true;
        HashSet<Character> appearedSet = new HashSet<Character>();
        for (int i = 0; i < gameRule.numbersLengh; i++) {
            Character letter = input.charAt(i);
            isCorrect = isCorrect && appearedSet.add(letter);
        }
        return isCorrect;
    }

    private boolean verifyNumbers(String input) {
        if (!this.verifyNumbersLength(input))
            return false;
        if (!this.verifyNumbersRange(input))
            return false;
        if (!this.verifyNumbersDuplication(input))
            return false;
        return true;
    }

    private int[] parseNumbers(String input) {
        int[] numbers = new int[gameRule.numbersLengh];
        for (int i = 0; i < gameRule.numbersLengh; i++) {
            numbers[i] = input.charAt(i) -'0';
        }
        return numbers;
    }

    public int[] getUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();
        boolean verification = this.verifyNumbers(input);
        while (!verification) {
            System.out.print("올바른 조건의 숫자를 입력해주세요 : ");
            input = scanner.nextLine();
            verification = this.verifyNumbers(input);
        }
        return this.parseNumbers(input);
    }

    public void printResult(GameRule.Result result) {
        if (result.strike == 0 && result.ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (result.strike > 0)
            System.out.print(result.strike + " 스트라이크 ");
        if (result.ball > 0)
            System.out.print(result.ball + " 볼");
        System.out.println();
    }

    private boolean verifyEndingStatus(String input) {
        if (input.equals("1") || input.equals("2"))
            return true;
        return false;
    }

    private boolean parseEndingStatus(String input) {
        if (input.equals("2"))
            return true;
        return false;
    }

    public boolean getEndingStatus() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        boolean verification = this.verifyEndingStatus(input);
        if (!verification) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = scanner.nextLine();
            verification = this.verifyEndingStatus(input);
        }
        return this.parseEndingStatus(input);
    }
}
