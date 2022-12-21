package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ComputerSimulator {
    List<Integer> answer;
    Scanner scanner = new Scanner(System.in);

    public void startNewGame() {
        answer = NumberGenerater.generate();

        while(true) {
            System.out.print("숫자를 입력해주세요: ");

            Integer input = scanner.nextInt();

            Ballcount ballcount = calculateBallcount(toIntegerList(input));
        }
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    private List<Integer> toIntegerList(Integer integer) {
        List<Integer> list = Arrays.asList();

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
}
