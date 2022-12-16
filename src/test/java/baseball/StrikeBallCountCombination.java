package baseball;

import baseball.domain.StrikeBallCount;

public enum StrikeBallCountCombination {
    count_00(0, 0, "낫싱"),
    count_01(0, 1, "1볼"),
    count_02(0, 2, "2볼"),
    count_03(0, 3, "3볼"),
    count_10(1, 0, "1스트라이크"),
    count_11(1, 1, "1스트라이크 1볼"),
    count_12(1, 2, "1스트라이크 2볼"),
    count_20(2, 0, "2스트라이크"),
    count_21(2, 1, "2스트라이크 1볼"),
    count_30(3, 0, "3스트라이크");
    public final int strikes;
    public final int balls;
    public final String result;
    StrikeBallCount sb;

    StrikeBallCountCombination(int strikes, int balls, String result) {
        this.strikes = strikes;
        this.balls = balls;
        this.result = result;
        sb = new StrikeBallCount();
        setStrikeBallCount();
    }

    private void setStrikeBallCount() {
        sb.resetCounts();
        for (int i = 0; i < strikes; i++) {
            sb.addStrikeCount();
        }
        for (int i = 0; i < balls; i++) {
            sb.addBallCount();
        }
    }

    public StrikeBallCount getStrikeBallCount() {
        return sb;
    }
}
