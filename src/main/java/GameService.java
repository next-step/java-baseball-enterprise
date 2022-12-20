import java.util.Arrays;

public class GameService {

    public ResultEntity getResult(int[] answer, int[] input){
        ResultEntity result = new ResultEntity(0, 0);
        int[] posArr = makePosArr(answer);

        for(int idx = 0; idx < 3; idx++){
            int pos = posArr[input[idx]];
            if(pos == idx) result.addStrike();
            if(pos != idx && pos != -1) result.addBall();
        }

        System.out.println(result);
        return result;
    }
    private int[] makePosArr(int[] answer){
        int[] ret = new int[10];
        Arrays.fill(ret, -1);

        for(int idx = 0; idx < 3; idx++){
            ret[answer[idx]] = idx;
        }

        return ret;
    }

    public boolean isFinish(ResultEntity result){
        if(result.getStrike() == 3){
            System.out.println(Message.END_MSG.getMsgStr());
            return true;
        }
        return false;
    }
}
