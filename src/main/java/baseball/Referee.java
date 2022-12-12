package baseball;

public class Referee {

    public static Judgement judge(String rightNumbers, String inputNumbers) {
        int strikeCount = judgeStrikeCount(rightNumbers, inputNumbers);
        int ballCount = judgeBallCount(rightNumbers, inputNumbers);
        return new Judgement(strikeCount, ballCount);
    }

    private static int judgeStrikeCount(String rightNumbers, String inputNumbers) {
        int strikeCount = 0;
        for (int index = 0; index < inputNumbers.length(); index++) {
            char rightNumber = rightNumbers.charAt(index);
            char inputNumber = inputNumbers.charAt(index);
            strikeCount += countAccumulation(rightNumber, inputNumber);
        }
        return strikeCount;
    }

    private static int countAccumulation(char rightNumber, char inputNumber) {
        return inputNumber == rightNumber ? 1 : 0;
    }

    private static int judgeBallCount(String rightNumbers, String inputNumbers) {
        int ballCount = 0;
        for (int rightNumberIndex = 0; rightNumberIndex < rightNumbers.length(); rightNumberIndex++) {
            ballCount += eachRightNumberBallCountAccumulation(rightNumbers, inputNumbers, rightNumberIndex);
        }
        return ballCount;
    }

    private static int eachRightNumberBallCountAccumulation(
            String rightNumbers, String inputNumbers, int rightNumberIndex
    ) {
        int ballCount = 0;
        for (int inputNumberIndex = 0; inputNumberIndex < inputNumbers.length(); inputNumberIndex++) {
            ballCount += ballCountAccumulation(rightNumbers, inputNumbers, rightNumberIndex, inputNumberIndex);
        }
        return ballCount;
    }

    private static int ballCountAccumulation(
            String rightNumbers, String inputNumbers, int rightNumberIndex, int inputNumberIndex
    ) {
        int ballCount = 0;
        if (rightNumberIndex != inputNumberIndex) {
            char rightNumber = rightNumbers.charAt(rightNumberIndex);
            char inputNumber = inputNumbers.charAt(inputNumberIndex);
            ballCount += countAccumulation(rightNumber, inputNumber);
        }
        return ballCount;
    }
}
