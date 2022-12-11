package baseball.domain;

import baseball.constant.Constant;

public class StrikeBallCount {
    private int strikeCount;
    private int ballCount;
    private final int length;

    public StrikeBallCount(){
        length = Constant.LENGTH.getValue();
    }

    public void resetCounts(){
        strikeCount = 0;
        ballCount = 0;
    }
    public void addStrikeCount(){
        strikeCount++;
    }
    public void addBallCount(){
        ballCount++;
    }

    public int getStrikeCount(){
        return strikeCount;
    }

    public int getBallCount(){
        return ballCount;
    }

    public boolean getIsComplete() {
        return strikeCount == length;
    }
}
