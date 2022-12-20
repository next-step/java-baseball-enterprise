import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResultEntity {
    private Integer strike;
    private Integer ball;
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(this.strike > 0) sb.append(this.strike).append(" 스트라이크 ");
        if(this.ball > 0) sb.append(this.ball).append(" 볼");
        if(this.strike == 0 && this.ball == 0) sb.append("낫싱");

        return sb.toString();
    }

    public void addStrike(){
        this.strike++;
    }
    public void addBall(){
        this.ball++;
    }
}
