package game;

import service.RandomGenerator;
import service.StrikeBallCount;
import service.SubmissionValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private final List<Integer> answer;
    private final List<Integer> userInput = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public BaseballGame() {
        this.answer = RandomGenerator.generateRandomNumber();
    }

    public Boolean playGame() {
        Boolean stop = false;
        while (!stop) {
            stop = progressGame();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextInt() == 1;
    }

    private Boolean progressGame() {
        setUserInput();
        StrikeBallCount strikeBallCount = SubmissionValidator.validateSubmission(userInput, answer);
        System.out.println(strikeBallCount.getResultString());
        return strikeBallCount.isCorrect();
    }

    private void setUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        String input = scanner.nextLine().replaceAll("\\s", "");
        if (isInputValid(input)) {
            updateUserInput(input);
            return;
        }
        System.out.println("올바른 숫자를 입력해 주세요!");
        setUserInput();
    }

    private void updateUserInput(String input) {
        userInput.clear();
        for (int i = 0; i < 3; i++) {
            userInput.add(Character.getNumericValue(input.charAt(i)));
        }
    }

    private boolean isInputValid(String input) {
        if (input.length() != 3) return false;
        int idx = 0;
        while (idx < 3 && Character.isDigit(input.charAt(idx)) && Character.getNumericValue(input.charAt(idx)) > 0) {
            idx++;
        }
        if (idx != 3) {
            return false;
        }
        return true;
    }
}
