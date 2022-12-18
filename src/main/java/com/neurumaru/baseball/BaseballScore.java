package com.neurumaru.baseball;

import java.util.List;

public class BaseballScore {
    private int strike = 0;
    private int ball = 0;

    public BaseballScore(BaseballNumbers playerBaseballNumbers, BaseballNumbers computerBaseballNumbers) {
        calculateScore(playerBaseballNumbers.getNumbers(), computerBaseballNumbers.getNumbers());
    }

    private void calculateScore(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        if (!isValidNumbers(playerNumbers, computerNumbers)) {
            return;
        }
        calculateStrikeScore(playerNumbers, computerNumbers);
        calculateBallScore(playerNumbers, computerNumbers);
    }

    private void calculateStrikeScore(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        strike = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            strike += Boolean.compare(playerNumbers.get(i).equals(computerNumbers.get(i)), false);
        }
    }

    private void calculateBallScore(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        ball = 0;
        for (Integer playerNumber : playerNumbers) {
            ball += Boolean.compare(computerNumbers.contains(playerNumber), false);
        }
        ball -= strike;
    }

    private boolean isValidNumbers(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        return playerNumbers != null && computerNumbers != null && playerNumbers.size() == computerNumbers.size();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}