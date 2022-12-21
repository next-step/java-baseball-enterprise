package baseball.model;

import baseball.dto.GuessResult;

public class Game {

    private final int[] answer;
    private boolean cleared;

    public boolean isCleared() {
        return cleared;
    }

    public Game(int[] answer) {
        this.answer = answer;
        this.cleared = false;
    }

    public GuessResult check(int input) {
        int[] guess = new int[] {input / 100, input / 10 % 10, input % 10};
        GuessResult result = new GuessResult(0, 0);
        for (int guessIndex = 0; guessIndex < 3; guessIndex++) {
            checkSingleNumberOfGuess(guess, result, guessIndex);
        }
        if (result.getStrike() == 3) {
            this.cleared = true;
        }
        return result;
    }

    private void checkSingleNumberOfGuess(int[] guess, GuessResult result, int guessIndex) {
        for (int answerIndex = 0; answerIndex <3; answerIndex++) {
            compareAndIncreaseCount(guess, result, guessIndex, answerIndex);
        }
    }

    private void compareAndIncreaseCount(int[] guess, GuessResult result, int guessIndex, int answerIndex) {
        if (guess[guessIndex] == answer[answerIndex]) {
            result.increaseCount(guessIndex, answerIndex);
        }
    }
}
