package baseball.domain.computer;

import baseball.domain.user.UserInput;
import baseball.domain.result.Result;

import java.util.Iterator;

public class Computer {
    RandomNumbers answers;

    public Computer() {
        this.answers = new RandomNumbers();
    }

    public Computer(RandomNumbers answers) {
        this.answers = answers;
    }

    public Result calculateResult(UserInput input) {
        int strike = calculateStrike(input);
        return new Result(strike, calculateBall(input) - strike);
    }
    private int calculateBall(UserInput userInput) {
        return userInput.intersect(answers);
    }

    private int calculateStrike(UserInput userInput) {
        return getNumberOfStrike(userInput.iterator(), answers.iterator());
    }

    public int getNumberOfStrike(Iterator<Integer> input, Iterator<Integer> answers) {
        int strike = 0;
        while(input.hasNext()) {
            strike += addValueIfIsStrike(input, answers);
        }
        return strike;
    }

    private int addValueIfIsStrike(Iterator<Integer> input, Iterator<Integer> answer) {
        if(input.next().equals(answer.next())) {
            return 1;
        }
        return 0;
    }
}
