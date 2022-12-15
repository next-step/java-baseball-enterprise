package domain;

public class JudgeResult {

    private int strikesNum;
    private int ballNum;

    public JudgeResult(int strikesNum, int ballNum) {
        this.strikesNum = strikesNum;
        this.ballNum = ballNum;
    }

    public int getStrikesNum() {
        return strikesNum;
    }

    public int getBallNum() {
        return ballNum;
    }

    public void change(int strikesNum, int ballNum){
        this.ballNum = ballNum;
        this.strikesNum = strikesNum;
    }
}
