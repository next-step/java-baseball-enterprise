package baseball;

public class Referee {

    public static Judgement judge(String rightNumbers, String inputNumbers) {
        if (strikeCount(rightNumbers, inputNumbers) == 1) {
            return Judgement.ONE_STRIKE;
        } else if(strikeCount(rightNumbers, inputNumbers) == 2) {
            return Judgement.TWO_STRIKE;
        }
        return Judgement.FOUR_BALL;
    }

    private static int strikeCount(String rightNumbers, String inputNumbers) {
        int strikeCount = 0;
        for (int index = 0; index < inputNumbers.length(); index++) {
            char rightNumber = rightNumbers.charAt(index);
            char inputNumber = inputNumbers.charAt(index);
            strikeCount += strikeCountAccumulation(rightNumber, inputNumber);
        }
        return strikeCount;
    }

    private static int strikeCountAccumulation(char rightNumber, char inputNumber) {
        if (isStrike(inputNumber, rightNumber)) {
            return 1;
        }
        return 0;
    }

    private static boolean isStrike(char rightNumber, char inputNumber) {
        return rightNumber == inputNumber;
    }
}
