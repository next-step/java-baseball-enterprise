package service;

import java.util.List;

public class SubmissionValidator {
    public static StrikeBallCount validateSubmission(List<Integer> submission, List<Integer> answer) {
        StrikeBallCount strikeBallCount = new StrikeBallCount();
        for (int idx = 0; idx < 3; idx++) {
            updateStrikeBallCountPerIdx(idx, submission, answer, strikeBallCount);
        }
        return strikeBallCount;
    }

    private static void updateStrikeBallCountPerIdx(int idx, List<Integer> submission, List<Integer> answer, StrikeBallCount strikeBallCount) {
        if (submission.get(idx).equals(answer.get(idx))) {
            strikeBallCount.updateStrike();
            return;
        }
        if(answer.contains(submission.get(idx))) {
            strikeBallCount.updateBall();
            return;
        }
    }
}
