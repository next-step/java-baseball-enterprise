package game;

import java.util.Arrays;

public class GameService {

    public ResultEntity calcResult(int[] answer, int[] input){
        ResultEntity result = new ResultEntity(0, 0);
        //answer 배열의 각 원소 위치를 저장하는 배열, 없는 원소면 -1
        int[] answerIdxArr = makeAnswerIdxArr(answer);

        for(int inputIdx = 0; inputIdx < 3; inputIdx++){
            int answerIdx = answerIdxArr[input[inputIdx]];
            if(answerIdx == inputIdx) result.addStrike();
            if(answerIdx != inputIdx && answerIdx != -1) result.addBall();
        }

        System.out.println(result);
        return result;
    }
    private int[] makeAnswerIdxArr(int[] answer){
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
