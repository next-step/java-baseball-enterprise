package domain.number_baseball.model;

import domain.number_baseball.common.NumberBaseballSetting;
import global.model.InputVerifier;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComputerStrategy implements NumberBaseballOpponentStrategy {
    private String answer;

    @Override
    public void setAnswer() {
        int answer = 0;
        List<Integer> numbersList = Arrays.asList(NumberBaseballSetting.NUMBER_PRESET);

        Collections.shuffle(numbersList);
        for(int i = 0; i < NumberBaseballSetting.MAX_BALL_NUMBER; i++) {
            answer = answer * 10 + numbersList.get(i);
        }

        this.answer = Integer.toString(answer);
    }

    @Override
    public int countBallScore(String input) {
        int numberOfBall = 0;

        if(isIllegalInput(input)) {
            return 0;
        }
        for(int i = 0; i < NumberBaseballSetting.MAX_BALL_NUMBER; i++) {
            numberOfBall += ballScoreWithSingleTarget(input.charAt(i), i);
        }

        return numberOfBall;
    }

    private int ballScoreWithSingleTarget(char target, int index) {
        boolean answerContainsCurrentTarget = answer.contains(String.valueOf(target));
        int currentTargetIndex = answer.indexOf(target);

        if(answerContainsCurrentTarget && currentTargetIndex >= 0 && currentTargetIndex != index) {
            return 1;
        }

        return 0;
    }

    @Override
    public int countStrikeScore(String input) {
        int numberOfStrike = 0;

        if(isIllegalInput(input)) {
            return 0;
        }
        for(int i = 0; i < NumberBaseballSetting.MAX_BALL_NUMBER; i++) {
            numberOfStrike += strikeScoreWithSingleTarget(input.charAt(i), i);
        }

        return numberOfStrike;
    }

    private int strikeScoreWithSingleTarget(char target, int index) {
        boolean answerContainsCurrentTarget = answer.contains(String.valueOf(target));
        int currentTargetIndex = answer.indexOf(target);

        if (answerContainsCurrentTarget && currentTargetIndex == index) {
            return 1;
        }

        return 0;
    }

    private boolean isIllegalInput(String input) {
        InputVerifier verifier = InputVerifier.getInstance();

        return !verifier.isIntegerWithLength(input, NumberBaseballSetting.MAX_BALL_NUMBER) || verifier.hasZero(input);
    }

    @Override
    public boolean isAnswer(String input) {
        return input.equals(answer);
    }
}
