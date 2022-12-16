package baseball.dto;

public class StrikeBallCountDto {
    private final int strikeCnt;
    private final int ballCnt;

    public StrikeBallCountDto(int strikeCnt, int ballCnt) {
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
        return "StrikeBallCountDto{" +
                "strikeCnt=" + strikeCnt +
                ", ballCnt=" + ballCnt +
                '}';
    }
}
