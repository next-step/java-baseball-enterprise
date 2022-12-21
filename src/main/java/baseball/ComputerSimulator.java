package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ComputerSimulator {
    List<Integer> answer;
    Scanner scanner = new Scanner(System.in);

    public void simulate() {
        Boolean gameFinished = false;

        while (!gameFinished) {
            startNewGame();

            gameFinished = getGameFinishedInput();
        }
    }

    public void startNewGame() {
        answer = NumberGenerater.generate();
        Ballcount ballcount = Ballcount.of(0, 0);

        while(!isGameFinished(ballcount)) {
            System.out.print("숫자를 입력해주세요: ");

            Integer input = scanner.nextInt();

            ballcount = calculateBallcount(toIntegerList(input));

            printBallcount(ballcount);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니! 게임 종료");
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    private List<Integer> toIntegerList(Integer integer) {
        List<Integer> list = new ArrayList<>();

        list.add(integer / 100);
        list.add((integer % 100) / 10);
        list.add(integer % 10);

        return list;
    }

    public Ballcount calculateBallcount(List<Integer> input) {
        int strikes = 0, balls = 0;

        for (int index = 0; index < 3; index++) {
            Ballcount ballcount = calculateBallcountForIndex(input.get(index), index);
            strikes += ballcount.getStrikes();
            balls += ballcount.getBalls();
        }

        return Ballcount.of(strikes, balls);
    }

    private Ballcount calculateBallcountForIndex(int input, int index) {
        if (input == answer.get(index)) {
            return Ballcount.of(1, 0);
        }

        if (answer.contains(input)) {
            return Ballcount.of(0, 1);
        }

        return Ballcount.of(0, 0);
    }

    public boolean isGameFinished(Ballcount ballcount) {
        return ballcount.getStrikes() == 3;
    }

    private void printBallcount(Ballcount ballcount) {
        String result = "";
        if (ballcount.getStrikes() > 0) {
            result += ballcount.getStrikes() + " 스트라이크 ";
        }
        if (ballcount.getBalls() > 0) {
            result += ballcount.getBalls() + " 볼 ";
        }
        if (result.isEmpty()) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(result);
    }

    private boolean getGameFinishedInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Integer input = scanner.nextInt();

        if (input == 1) {
            return false;
        }

        return true;
    }
}
