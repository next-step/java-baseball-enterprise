class Result {
    int strike;
    int ball;
    int numberLength;

    Result(String answerNumber, String submitNumber) {
        numberLength = answerNumber.length();
        for (int i = 0; i < numberLength; i++) {
            checkIndex(answerNumber, submitNumber.charAt(i), i);
        }
    }

    private void checkIndex(String answerNumber, char n, int idx) {
        if (answerNumber.charAt(idx) == n) {
            addStrike();
        }
        else if (answerNumber.indexOf(n) != -1) {
            addBall();
        }
    }

    void addStrike() {
        strike += 1;
    }

    void addBall() {
        ball += 1;
    }

    boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    boolean isCorrect() {
        return strike == numberLength;
    }

    String strikeString() {
        if (strike == 0) {
            return "";
        }
        return String.format("%d 스트라이크 ", strike);
    }

    String ballString() {
        if (ball == 0) {
            return "";
        }
        return String.format("%d볼", ball);
    }

    String resultString() {
        if (isNothing()) {
            return "낫싱";
        }
        return strikeString() + ballString();
    }
}
