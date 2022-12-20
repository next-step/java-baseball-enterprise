package com.neurumaru.baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballStageInputValidatorTest {
    @Test
    void isValidTest() {
        Validator<Integer> validator = new BaseballStageInputValidator(3);
        assertThat(validator.isValid(99)).isFalse();
        assertThat(validator.isValid(100)).isTrue();
        assertThat(validator.isValid(999)).isTrue();
        assertThat(validator.isValid(1000)).isFalse();
    }
}
