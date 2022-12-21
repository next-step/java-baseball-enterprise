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
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (guess[i] == answer[j]) {
                    if (i == j) {
                        result.increaseStrike();
                    } else if (i != j) {
                        result.increaseBall();
                    }
                }
            }
        }
        if (result.getStrike() == 3) {
            this.cleared = true;
        }
        return result;
    }
}
