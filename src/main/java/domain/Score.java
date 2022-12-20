package domain;

public class Score {
    private Integer strike;
    private Integer ball;

    public Score() {
        reset();
    }

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public boolean isFinish(){
        return this.strike == 3;
    }

    public String getScore(){
        StringBuilder sb = new StringBuilder();
        if (this.ball == 0 && this.strike == 0 ){
            return "낫싱";
        }
        if (this.strike > 0){
            sb.append(this.strike).append(" 스트라이크 ");
        }
        if (this.ball > 0){
            sb.append(this.ball).append(" 볼");
        }
        return sb.toString().trim();
    }

    public void reset() {
        this.strike = 0;
        this.ball = 0;
    }
}
