package baseball;

public class Referee {

    private final Numbers rightNumbers;

    public Referee(Numbers rightNumbers) {
        this.rightNumbers = rightNumbers;
    }

    public Judgements judge(Numbers inputNumbers) {
        int strikeCount = aggregateJudgement(inputNumbers, Judgement.STRIKE);
        int ballCount = aggregateJudgement(inputNumbers, Judgement.BALL);
        return new Judgements(strikeCount, ballCount);
    }

    private int aggregateJudgement(Numbers inputNumbers, Judgement expected) {
        int count = 0;
        for (Number rightNumber : rightNumbers) {
            count += aggregatedJudgementByEachNumber(rightNumber, inputNumbers, expected);
        }
        return count;
    }

    private int aggregatedJudgementByEachNumber(Number rightNumber, Numbers inputNumbers, Judgement expected) {
        int count = 0;
        for (Number inputNumber : inputNumbers) {
            Judgement actual = rightNumber.judge(inputNumber);
            count += accumulationByJudgement(actual, expected);
        }
        return count;
    }

    private int accumulationByJudgement(Judgement actual, Judgement expected) {
        return actual == expected ? 1 : 0;
    }
}
