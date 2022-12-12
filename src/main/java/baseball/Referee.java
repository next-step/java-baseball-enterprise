package baseball;

public class Referee {

    public static Judgement judge(String rightNumbers, String inputNumbers) {
        for (int index = 0; index < inputNumbers.length(); index++) {
            if (inputNumbers.charAt(index) == rightNumbers.charAt(index)) {
                return Judgement.STRIKE;
            }
        }

        return Judgement.FOUR_BALL;
    }
}
