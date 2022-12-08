package baseball;

import baseball.dto.StrikeBallCount;

import java.util.List;

public class StrikeBallCounter {
    public static StrikeBallCount countStrikeAndBall(List<Integer> computerNum, List<Integer> playerNum) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int idx = 0; idx < playerNum.size(); idx++) {
            strikeCnt += countStrike(computerNum, playerNum, idx);
            ballCnt += countBall(computerNum, playerNum, idx);
        }

        return new StrikeBallCount(strikeCnt, ballCnt);
    }

    private static int countStrike(List<Integer> computerNum, List<Integer> playerNum, int idx) {
        if (computerNum.get(idx).equals(playerNum.get(idx))) {
            return 1;
        }
        return 0;
    }

    private static int countBall(List<Integer> computerNum, List<Integer> playerNum, int idx) {
        if (!computerNum.get(idx).equals(playerNum.get(idx)) &&
                computerNum.contains(playerNum.get(idx))) {
            return 1;
        }
        return 0;
    }
}
