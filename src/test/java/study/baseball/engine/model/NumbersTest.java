package study.baseball.engine.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumbersTest {
    @Test
    public void testNothing() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Set<Integer> answer = new LinkedHashSet<>(Arrays.asList(4, 5, 6));
        Numbers numbers = new Numbers(answer);
        assertThat(numbers.getStrike(input)).isEqualTo(0);
        assertThat(numbers.getBall(input)).isEqualTo(0);
    }

    @Test
    public void testOneBall() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Set<Integer> answer = new LinkedHashSet<>(Arrays.asList(4, 1, 6));
        Numbers numbers = new Numbers(answer);
        assertThat(numbers.getStrike(input)).isEqualTo(0);
        assertThat(numbers.getBall(input)).isEqualTo(1);
    }

    @Test
    public void testTwoBall() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Set<Integer> answer = new LinkedHashSet<>(Arrays.asList(2, 1, 6));
        Numbers numbers = new Numbers(answer);
        assertThat(numbers.getStrike(input)).isEqualTo(0);
        assertThat(numbers.getBall(input)).isEqualTo(2);
    }

    @Test
    public void testThreeBall() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Set<Integer> answer = new LinkedHashSet<>(Arrays.asList(3, 1, 2));
        Numbers numbers = new Numbers(answer);
        assertThat(numbers.getStrike(input)).isEqualTo(0);
        assertThat(numbers.getBall(input)).isEqualTo(3);
    }

    @Test
    public void testOneStrike() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Set<Integer> answer = new LinkedHashSet<>(Arrays.asList(1, 5, 6));
        Numbers numbers = new Numbers(answer);
        assertThat(numbers.getStrike(input)).isEqualTo(1);
        assertThat(numbers.getBall(input)).isEqualTo(0);
    }

    @Test
    public void testOneStrikeOneBall() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Set<Integer> answer = new LinkedHashSet<>(Arrays.asList(1, 5, 2));
        Numbers numbers = new Numbers(answer);
        assertThat(numbers.getStrike(input)).isEqualTo(1);
        assertThat(numbers.getBall(input)).isEqualTo(1);
    }

    @Test
    public void testOneStrikeTwoBall() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Set<Integer> answer = new LinkedHashSet<>(Arrays.asList(1, 3, 2));
        Numbers numbers = new Numbers(answer);
        assertThat(numbers.getStrike(input)).isEqualTo(1);
        assertThat(numbers.getBall(input)).isEqualTo(2);
    }

    @Test
    public void testTwoStrike() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Set<Integer> answer = new LinkedHashSet<>(Arrays.asList(1, 2, 4));
        Numbers numbers = new Numbers(answer);
        assertThat(numbers.getStrike(input)).isEqualTo(2);
        assertThat(numbers.getBall(input)).isEqualTo(0);
    }

    @Test
    public void testThreeStrike() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Set<Integer> answer = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
        Numbers numbers = new Numbers(answer);
        assertThat(numbers.getStrike(input)).isEqualTo(3);
        assertThat(numbers.getBall(input)).isEqualTo(0);
    }
}