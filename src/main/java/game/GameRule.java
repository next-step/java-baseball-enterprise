package game;

public class GameRule {
    public int numbersLengh = 3;
    public int[] numbersRange = {1,2,3,4,5,6,7,8,9};


    private int judgeStrike(int num1, int num2) {
        if (num1 == num2)
            return 1;
        return 0;
    }

    private int judgeBall(int num, int[] numbers) {
        boolean isBall = false;
        for (int i = 0; i < numbersLengh; i++) {
            isBall = isBall || num == numbers[i];
        }
        if (isBall)
            return 1;
        return 0;
    }

    public class Result {
        public int strike;
        public int ball;
        public boolean isEnd;

        public Result(int strike, int ball,boolean isEnd) {
            this.strike = strike;
            this.ball = ball;
            this.isEnd = isEnd;
        }
    }

    public Result judgeResult(int[] numbers1, int[] numbers2) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < numbersLengh; i++) {
            strike += this.judgeStrike(numbers1[i], numbers2[i]);
            ball += this.judgeBall(numbers1[i], numbers2);
        }
        ball -= strike;
        return new Result(strike, ball, strike == numbersLengh);
    }
}

