package baseball;

public class Referee {

    public static Judgement judge(Numbers rightNumbers, Numbers inputNumbers) {
        int strikeCount = rightNumbers.judgeStrikeCount(inputNumbers);
        int ballCount = rightNumbers.judgeBallCount(inputNumbers);
        return new Judgement(strikeCount, ballCount);
    }
}
