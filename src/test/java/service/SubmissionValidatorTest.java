package service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class SubmissionValidatorTest {

    @Test
    void validateSubmission_isStrikeThree() {
        List<Integer> submission = new ArrayList<>();
        submission.add(1);
        submission.add(2);
        submission.add(3);

        List<Integer> answer = new ArrayList<>();
        answer.add(1);
        answer.add(2);
        answer.add(3);

        StrikeBallCount strikeBallCount = SubmissionValidator.validateSubmission(submission, answer);
        assertThat(strikeBallCount.getStrikeCount()).isEqualTo(3);
        assertThat(strikeBallCount.getBallCount()).isEqualTo(0);
    }

    @Test
    void validateSubmission_isStrikeThreeAndCorrect() {
        List<Integer> submission = new ArrayList<>();
        submission.add(1);
        submission.add(2);
        submission.add(3);

        List<Integer> answer = new ArrayList<>();
        answer.add(1);
        answer.add(2);
        answer.add(3);

        StrikeBallCount strikeBallCount = SubmissionValidator.validateSubmission(submission, answer);
        assertThat(strikeBallCount.getStrikeCount()).isEqualTo(3);
        assertThat(strikeBallCount.getBallCount()).isEqualTo(0);
        assertThat(strikeBallCount.isCorrect()).isTrue();
    }

    @Test
    void validateSubmission_isBallThree() {
        List<Integer> submission = new ArrayList<>();
        submission.add(1);
        submission.add(2);
        submission.add(3);

        List<Integer> answer = new ArrayList<>();
        answer.add(3);
        answer.add(1);
        answer.add(2);

        StrikeBallCount strikeBallCount = SubmissionValidator.validateSubmission(submission, answer);
        assertThat(strikeBallCount.getStrikeCount()).isEqualTo(0);
        assertThat(strikeBallCount.getBallCount()).isEqualTo(3);
    }

    @Test
    void validateSubmission_isTwoBallOneStrike() {
        List<Integer> submission = new ArrayList<>();
        submission.add(1);
        submission.add(2);
        submission.add(3);

        List<Integer> answer = new ArrayList<>();
        answer.add(1);
        answer.add(3);
        answer.add(2);

        StrikeBallCount strikeBallCount = SubmissionValidator.validateSubmission(submission, answer);
        assertThat(strikeBallCount.getStrikeCount()).isEqualTo(1);
        assertThat(strikeBallCount.getBallCount()).isEqualTo(2);
    }

    @Test
    void validateSubmission_isOneBall() {
        List<Integer> submission = new ArrayList<>();
        submission.add(1);
        submission.add(2);
        submission.add(3);

        List<Integer> answer = new ArrayList<>();
        answer.add(4);
        answer.add(5);
        answer.add(1);

        StrikeBallCount strikeBallCount = SubmissionValidator.validateSubmission(submission, answer);
        assertThat(strikeBallCount.getStrikeCount()).isEqualTo(0);
        assertThat(strikeBallCount.getBallCount()).isEqualTo(1);
    }

    @Test
    void validateSubmission_noMatch() {
        List<Integer> submission = new ArrayList<>();
        submission.add(1);
        submission.add(2);
        submission.add(3);

        List<Integer> answer = new ArrayList<>();
        answer.add(4);
        answer.add(5);
        answer.add(6);

        StrikeBallCount strikeBallCount = SubmissionValidator.validateSubmission(submission, answer);
        assertThat(strikeBallCount.getStrikeCount()).isEqualTo(0);
        assertThat(strikeBallCount.getBallCount()).isEqualTo(0);
    }

    @Test
    void validateSubmission_noMatchAndNothing() {
        List<Integer> submission = new ArrayList<>();
        submission.add(1);
        submission.add(2);
        submission.add(3);

        List<Integer> answer = new ArrayList<>();
        answer.add(4);
        answer.add(5);
        answer.add(6);

        StrikeBallCount strikeBallCount = SubmissionValidator.validateSubmission(submission, answer);
        assertThat(strikeBallCount.getStrikeCount()).isEqualTo(0);
        assertThat(strikeBallCount.getBallCount()).isEqualTo(0);
        assertThat(strikeBallCount.isNothing()).isTrue();
    }

    @Test
    void validateSubmission_resultStringIsTwoBallOneStrike() {
        List<Integer> submission = new ArrayList<>();
        submission.add(1);
        submission.add(2);
        submission.add(3);

        List<Integer> answer = new ArrayList<>();
        answer.add(1);
        answer.add(3);
        answer.add(2);

        StrikeBallCount strikeBallCount = SubmissionValidator.validateSubmission(submission, answer);
        assertThat(strikeBallCount.getResultString()).isEqualTo("1스트라이크 2볼");
    }

    @Test
    void validateSubmission_resultStringIsNothing() {
        List<Integer> submission = new ArrayList<>();
        submission.add(1);
        submission.add(2);
        submission.add(3);

        List<Integer> answer = new ArrayList<>();
        answer.add(4);
        answer.add(5);
        answer.add(6);

        StrikeBallCount strikeBallCount = SubmissionValidator.validateSubmission(submission, answer);
        assertThat(strikeBallCount.getResultString()).isEqualTo("낫싱");
    }
}