package com.neurumaru.baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationTest {
    @Test
    void randTest() {
        Permutation permutation = new Permutation(3, 2);
        permutation.rand();
        List<Integer> lookUpTable = List.of(0, 1, 2);
        List<Integer> list1 = permutation.map(lookUpTable);
        List<Integer> list2 = permutation.map(lookUpTable);
        permutation.rand();
        List<Integer> list3 = permutation.map(lookUpTable);
        assertThat(list1).isEqualTo(list2).isNotEqualTo(list3);
    }

    @Test
    void mapTest() {
        Permutation permutation = new Permutation(3, 2);
        permutation.rand();
        List<String> lookUpTable = List.of("10", "20", "30");
        List<String> stringPermutation = permutation.map(lookUpTable);
        assertThat(stringPermutation.size()).isEqualTo(2);
        for (String string : stringPermutation) {
            assertThat(string).isIn(lookUpTable);
        }
    }
}
