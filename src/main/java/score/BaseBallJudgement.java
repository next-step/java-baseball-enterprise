package score;

import java.util.List;

public enum BaseBallJudgement {

    STRIKE((answer, userNumber, pos) -> answer.get(pos).equals(userNumber)),
    BALL((answer, userNumber, pos) -> {
        if (STRIKE.hit(answer, userNumber, pos)) {
            return false;
        }
        return answer.contains(userNumber);
    }),
    NOTHING((answer, userNumber, pos) -> !answer.contains(userNumber));

    private final BaseBallCriterion criterion;

    BaseBallJudgement(BaseBallCriterion criterion) {
        this.criterion = criterion;
    }

    public boolean hit(List<Integer> answer, Integer userNumber, Integer pos) {
        return criterion.judge(answer, userNumber, pos);
    }
}
