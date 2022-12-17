package com.neurumaru.baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class BaseballScoreTest {
    @Test
    void BaseballScoreConstructorTest() {
        BaseballNumbers playerBaseballNumbers = new BaseballNumbers(List.of(5, 2, 7));
        BaseballNumbers computerBaseballNumbers = new BaseballNumbers(List.of(2, 4, 7));
        BaseballScore baseballScore = new BaseballScore(playerBaseballNumbers, computerBaseballNumbers);
        assertThat(baseballScore.getStrike()).isEqualTo(1);
        assertThat(baseballScore.getBall()).isEqualTo(1);
    }
}