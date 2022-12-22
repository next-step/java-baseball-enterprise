package baseball;
import java.util.ArrayList;
import java.util.List;

public class Referee {
    public int[] judge(String target, String input) {
        return new int[] {countStrike(convert(target), convert(input)), countBall(convert(target), convert(input))};
    }

    private List<Integer> convert(String string) {
        List<Integer> career = new ArrayList<>();
        for(String number: string.split("")) {
            career.add(Integer.parseInt(number));
        }
        return career;
    }

    private int countBall(List<Integer> target, List<Integer> input) {
        int ball = 0;
        if (target.get(0) == input.get(1) || target.get(0) == input.get(2)) {
            ball++;
        }
        if (target.get(1) == input.get(0) || target.get(1) == input.get(2)) {
            ball++;
        }
        if (target.get(2) == input.get(0) || target.get(2) == input.get(1)) {
            ball++;
        }
        return ball;
    }

    private int countStrike(List<Integer> target, List<Integer> input) {
        int strike = 0;
        if (target.get(0) == input.get(0)) {
            strike ++;
        }
        if (target.get(1) == input.get(1)) {
            strike ++;
        }
        if (target.get(2) == input.get(2)) {
            strike ++;
        }
        return strike;
    }
}
