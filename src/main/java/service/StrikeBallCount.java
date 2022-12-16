package service;

public class StrikeBallCount {
    private int strikeCount = 0;
    private int ballCount = 0;

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void updateStrike() {
        this.strikeCount += 1;
    }

    public void updateBall() {
        this.ballCount += 1;
    }

    public Boolean isCorrect() {
        return this.strikeCount == 3;
    }

    public Boolean isNothing() {
        return this.ballCount == 0 & this.strikeCount == 0;
    }

    public String getResultString() {
        StringBuilder res = new StringBuilder();
        if (this.strikeCount > 0) res.append(strikeCount).append("스트라이크 ");
        if (this.ballCount > 0) res.append(ballCount).append("볼");
        if (this.isNothing()) res.append("낫싱");
        return res.toString();
    }
}
