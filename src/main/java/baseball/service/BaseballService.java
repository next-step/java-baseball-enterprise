package baseball.service;

import baseball.domain.BaseballNumber;
import java.util.List;

public class BaseballService {

    private final int RUNNING = 1;
    private final int READY = 0;
    private final BaseballNumber baseballNumber;
    private int status;

    public BaseballService(BaseballNumber baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public int getBallCount(List<Integer> userBaseballNumber) {
        List<Integer> computerBaseballNumber = baseballNumber.getNumber();
        int ballCount = 0;

        for (int i = 0; i < userBaseballNumber.size(); i++) {
            for (int j = 0; j < computerBaseballNumber.size(); j++){
                if (i != j & userBaseballNumber.get(i).equals(computerBaseballNumber.get(j))) {
                    ballCount++;
                }
            }
        }

        return ballCount;
    }

    public int getStrikeCount(List<Integer> userBaseballNumber) {
        List<Integer> computerBaseballNumber = baseballNumber.getNumber();
        int strikeCount = 0;

        for (int i = 0; i < userBaseballNumber.size(); i++) {
            if (userBaseballNumber.get(i).equals(computerBaseballNumber.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public boolean isPlaying() {
        return status == RUNNING;
    }

    public void startGame(){
        status = RUNNING;
        baseballNumber.generateBaseballNumber();
    }

    public void finishGame(){
        status = READY;
    }

    public void setBaseballNumber(List<Integer> baseballNumber) {
        this.baseballNumber.setNumber(baseballNumber);
    }
}
