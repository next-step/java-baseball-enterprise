package com.neurumaru.baseball;

public interface Validator<T> {
    boolean isValid(T variable);
}
