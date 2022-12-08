package baseball.dto;

public class StrikeBallCount {
    private int strikeCnt;
    private int ballCnt;

    public StrikeBallCount(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    @Override
    public String toString() {
        return "StrikeBallCount{" +
                "strikeCnt=" + strikeCnt +
                ", ballCnt=" + ballCnt +
                '}';
    }
}
