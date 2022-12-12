package baseball;

class Numbers {

    private final String value;

    public Numbers(String value) {
        this.value = value;
    }

    public int judgeStrikeCount(Numbers numbers) {
        int strikeCount = 0;
        for (int index = 0; index < numbers.value.length(); index++) {
            char rightNumber = value.charAt(index);
            char inputNumber = numbers.value.charAt(index);
            strikeCount += countAccumulation(rightNumber, inputNumber);
        }
        return strikeCount;
    }

    private static int countAccumulation(char rightNumber, char inputNumber) {
        return inputNumber == rightNumber ? 1 : 0;
    }

    public int judgeBallCount(Numbers numbers) {
        int ballCount = 0;
        for (int rightNumberIndex = 0; rightNumberIndex < value.length(); rightNumberIndex++) {
            ballCount += eachRightNumberBallCountAccumulation(value, numbers.value, rightNumberIndex);
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
