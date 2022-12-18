public class Judgement {
    private int[] answerNumbers, userNumbers;

    private int[] userInputToArray(String userInput) {
        int[] userNumbers = new int[userInput.length()];
        for (int i = 0; i < userNumbers.length; i++) {
            userNumbers[i] = Character.getNumericValue(userInput.charAt(i));
        }
        return userNumbers;
    }

    private int isDigitEqual(int answerNumberPos, int userNumberPos) {
        return answerNumbers[answerNumberPos] == userNumbers[userNumberPos] ? 1 : 0;
    }

    private int getStrikes() {
        int strikes = 0;
        for (int i = 0; i < answerNumbers.length; i++) {
            strikes += isDigitEqual(i, i);
        }
        return strikes;
    }

    private int isOtherDigitEqual(int answerNumberPos, int userNumberPos) {
        if (answerNumberPos == userNumberPos) {
            return 0;
        }
        return isDigitEqual(answerNumberPos, userNumberPos);
    }

    private int compareOtherDigits(int userNumberPos) {
        int otherPosCnt = 0;
        for (int i = 0; i < answerNumbers.length && otherPosCnt == 0; i++) {
            otherPosCnt += isOtherDigitEqual(i, userNumberPos);
        }
        return otherPosCnt;
    }

    private int getBalls() {
        int balls = 0;
        for (int i = 0; i < answerNumbers.length; i++) {
            balls += compareOtherDigits(i);
        }
        return balls;
    }

    public JudgementResult judge(int[] answerNumbers, String userInput) {
        int[] userNumbers = userInputToArray(userInput);
        this.answerNumbers = answerNumbers;
        this.userNumbers = userNumbers;
        int strikes = getStrikes();
        int balls = getBalls();
        return new JudgementResult(strikes, balls);
    }
}
