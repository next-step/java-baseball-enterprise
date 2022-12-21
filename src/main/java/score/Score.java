package score;

import java.util.List;
import java.util.Objects;

import static score.BaseBallJudgement.BALL;
import static score.BaseBallJudgement.STRIKE;

public class Score {

    private Integer strikeCount;

    private Integer ballCount;

    public Score(Integer strikeCount, Integer ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public Integer getStrikeCount() {
        return strikeCount;
    }

    public Integer getBallCount() {
        return ballCount;
    }

    public void updateScore(List<Integer> answer, Integer userNumber, Integer pos) {
        if (STRIKE.hit(answer, userNumber, pos)) {
            strikeCount += 1;
            return;
        }
        if (BALL.hit(answer, userNumber, pos)) {
            ballCount += 1;
            return;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return Objects.equals(strikeCount, score.strikeCount) && Objects.equals(ballCount, score.ballCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }
}
