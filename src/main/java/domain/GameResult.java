package domain;

public class GameResult {
    
    private int strikeCount;
    private int ballCount;

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public String getDescription() {
        StringBuilder sb = new StringBuilder();

        sb.append(checkIsNothing());
        sb.append(checkStrikeCount());
        sb.append(checkBallCount());

        return sb.toString();
    }

    public void increaseStrikeCount() {
        strikeCount += 1;
    }

    public void increaseBallCount() {
        ballCount += 1;
    }

    public String checkIsNothing() {
        return strikeCount + ballCount == 0 ? "낫싱" : "";
    }

    public String checkStrikeCount() {
        return strikeCount > 0 ? strikeCount + "스트라이크 " : "";
    }

    public String checkBallCount() {
        return ballCount > 0 ? ballCount + "볼" : "";
    }

}
