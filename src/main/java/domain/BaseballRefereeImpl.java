package domain;

import java.util.List;

public class BaseballRefereeImpl implements BaseballReferee {
    @Override
    public JudgeResult judge(List<Integer> answer, List<Integer> baseballGameInput) {
        JudgeResult judgeResult = new JudgeResult(0, 0);
        for (int i = 0; i < 3; i++) {
            checkBallAndStrike(answer, baseballGameInput, i, judgeResult);
        }
        return judgeResult;
    }

    private void checkBallAndStrike(List<Integer> answer, List<Integer> baseballGameInput, int idx, JudgeResult judgeResult) {
        if (isStrike(answer, baseballGameInput, idx)) {
            judgeResult.change(judgeResult.getStrikesNum() + 1, judgeResult.getBallNum());
            return;
        }
        if (isBall(answer, baseballGameInput, idx)) {
            judgeResult.change(judgeResult.getStrikesNum(), judgeResult.getBallNum() + 1);
        }
    }

    private boolean isStrike(List<Integer> answer, List<Integer> baseballGameInput, int idx) {
        return answer.get(idx).equals(baseballGameInput.get(idx));
    }

    private boolean isBall(List<Integer> answer, List<Integer> baseballGameInput, int idx) {
        return answer.contains(baseballGameInput.get(idx));
    }
}
