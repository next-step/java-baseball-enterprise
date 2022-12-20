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

    public void change(int strikesNum, int ballNum) {
        this.ballNum = ballNum;
        this.strikesNum = strikesNum;
    }
    public void change(JudgeResult judgeResult){
        this.strikesNum = judgeResult.getStrikesNum();
        this.ballNum = judgeResult.getBallNum();
    }


    public String toString() {
        if (ballNum == 0 && strikesNum == 0)
            return "낫싱";
        if (strikesNum != 0 && ballNum != 0) {
            return strikeToString() + " " + ballToString();
        }
        return strikeToString() + ballToString();
    }

    private String strikeToString() {
        if (strikesNum == 0) {
            return "";
        }
        return strikesNum + " 스트라이크";
    }

    private String ballToString() {
        if (ballNum == 0) {
            return "";
        }
        return ballNum + " 볼";
    }
}
