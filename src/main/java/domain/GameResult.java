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

        checkIsNothing(sb);
        checkStrikeCount(sb);
        checkBallCount(sb);

        return sb.toString();
    }

    public void increaseStrikeCount() {
        strikeCount += 1;
    }

    public void increaseBallCount() {
        ballCount += 1;
    }

    public void checkIsNothing(StringBuilder sb) {
        if (strikeCount + ballCount == 0) {
            sb.append("낫싱");
        }
    }

    public void checkStrikeCount(StringBuilder sb) {
        if (strikeCount > 0) {
            sb.append(strikeCount + "스트라이크 ");
        }
    }

    public void checkBallCount(StringBuilder sb) {
        if (ballCount > 0) {
            sb.append(ballCount + "볼");
        }
    }

}
