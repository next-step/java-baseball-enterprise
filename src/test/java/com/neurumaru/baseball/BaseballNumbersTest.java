package com.neurumaru.baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumbersTest {
    @Test
    void BaseballNumbersConstructor0Test() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(3);
        List<Integer> numbers = baseballNumbers.getNumbers();
        for (Integer number : numbers) {
            assertThat(number).isIn(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        }
    }

    @Test
    void BaseballNumbersConstructor1Test() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(3, 435);
        List<Integer> numbers = baseballNumbers.getNumbers();
        for (int i = 0, number = 435; i < numbers.size(); i++, number /= 10) {
            assertThat(numbers.get(numbers.size() - 1 - i)).isEqualTo(number % 10);
        }
    }

    @Test
    void getNumbersTest() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(List.of(4, 3, 5));
        assertThat(baseballNumbers.getNumbers()).isEqualTo(List.of(4, 3, 5));
    }

    @Test
    void cutMinMaxTest() {
        assertThat(BaseballNumbers.cutMinMax(10, 0, 9)).isEqualTo(9);
        assertThat(BaseballNumbers.cutMinMax(9, 0, 9)).isEqualTo(9);
        assertThat(BaseballNumbers.cutMinMax(0, 0, 9)).isEqualTo(0);
        assertThat(BaseballNumbers.cutMinMax(-1, 0, 9)).isEqualTo(0);
    }
}
