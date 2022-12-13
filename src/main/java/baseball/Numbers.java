package baseball;

import java.util.ArrayList;
import java.util.List;

class Numbers {

    private final List<Number> value;

    public Numbers(String numbers) {
        value = new ArrayList<>();

        for (int i = 0; i < numbers.length(); i++) {
            value.add(new Number(numbers.charAt(i), i));
        }
    }

    public Judgements judge(Numbers otherNumbers) {
        int strikeCount = aggregateJudgement(otherNumbers, Judgement.STRIKE);
        int ballCount = aggregateJudgement(otherNumbers, Judgement.BALL);
        return new Judgements(strikeCount, ballCount);
    }

    private int aggregateJudgement(Numbers otherNumbers, Judgement expected) {
        int count = 0;
        for (Number thisNumber : value) {
            count += aggregatedJudgementByThisNumber(thisNumber, otherNumbers, expected);
        }
        return count;
    }

    private int aggregatedJudgementByThisNumber(Number thisNumber, Numbers otherNumbers, Judgement expected) {
        int count = 0;
        for (Number otherNumber : otherNumbers.value) {
            Judgement actual = thisNumber.judge(otherNumber);
            count += accumulationByJudgement(actual, expected);
        }
        return count;
    }

    private int accumulationByJudgement(Judgement actual, Judgement expected) {
        return actual == expected  ? 1 : 0;
    }
}
