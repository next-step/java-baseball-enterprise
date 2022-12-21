package score;

import java.util.Objects;

public class Score {

    private final Integer strikeCount;

    private final Integer ballCount;

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
