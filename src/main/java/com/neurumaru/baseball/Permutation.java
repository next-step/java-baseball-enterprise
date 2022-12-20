package com.neurumaru.baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
    private final List<Integer> numberList;
    private final int r;

    public Permutation(int n, int r) {
        numberList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            numberList.add(i);
        }
        this.r = r;
    }

    public void rand() {
        Collections.shuffle(numberList);
    }

    public <T> List<T> map(List<T> lookUpTable) {
        List<T> result = new ArrayList<>(r);
        for (int i = 0; i < r; i++) {
            result.add(lookUpTable.get(numberList.get(i)));
        }
        return result;
    }
}
