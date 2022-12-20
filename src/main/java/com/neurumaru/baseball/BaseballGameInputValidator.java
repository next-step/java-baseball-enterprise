package com.neurumaru.baseball;

public class BaseballGameInputValidator implements Validator<Integer> {
    private final int restart_number;
    private final int quit_number;

    public BaseballGameInputValidator(int restart_number, int quit_number) {
        this.restart_number = restart_number;
        this.quit_number = quit_number;
    }

    @Override
    public boolean isValid(Integer variable) {
        return variable == restart_number || variable == quit_number;
    }
}
