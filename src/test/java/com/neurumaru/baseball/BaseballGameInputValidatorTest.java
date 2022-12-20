package com.neurumaru.baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameInputValidatorTest {
    @Test
    void isValidTest() {
        Validator<Integer> validator = new BaseballGameInputValidator(1, 2);
        assertThat(validator.isValid(0)).isFalse();
        assertThat(validator.isValid(1)).isTrue();
        assertThat(validator.isValid(2)).isTrue();
        assertThat(validator.isValid(3)).isFalse();
    }
}
