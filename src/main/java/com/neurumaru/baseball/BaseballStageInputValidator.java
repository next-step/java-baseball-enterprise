package com.neurumaru.baseball;

public class BaseballStageInputValidator implements Validator<Integer> {
    private final int digit;

    public BaseballStageInputValidator(int digit) {
        this.digit = digit;
    }

    @Override
    public boolean isValid(Integer variable) {
        return (int) Math.log10(variable) + 1 == digit;
    }
}
