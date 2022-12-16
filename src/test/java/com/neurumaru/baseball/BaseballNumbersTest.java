package com.neurumaru.baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumbersTest {
    @Test
    void BaseBallNumbersTest() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(3);
        List<Integer> numbers = baseballNumbers.getNumbers();
        for (Integer number : numbers) {
            assertThat(number).isIn(BaseballNumbers.lookUpTable);
        }
    }

    @Test
    void getNumbersTest() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(List.of(4, 3, 5));
        assertThat(baseballNumbers.getNumbers()).isEqualTo(List.of(4, 3, 5));
    }

    @Test
    void equalsTest() {
        BaseballNumbers baseballNumbers1 = new BaseballNumbers(List.of(4, 3, 5));
        BaseballNumbers baseballNumbers2 = new BaseballNumbers(List.of(4, 3, 5));
        assertThat(baseballNumbers1.equals(baseballNumbers2)).isTrue();
    }

    @Test
    void cutMinMaxTest() {
        assertThat(BaseballNumbers.cutMinMax(10, 0, 9)).isEqualTo(9);
        assertThat(BaseballNumbers.cutMinMax(9, 0, 9)).isEqualTo(9);
        assertThat(BaseballNumbers.cutMinMax(0, 0, 9)).isEqualTo(0);
        assertThat(BaseballNumbers.cutMinMax(-1, 0, 9)).isEqualTo(0);
    }
}
