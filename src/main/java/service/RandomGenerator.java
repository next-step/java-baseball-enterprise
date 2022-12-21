package service;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    public static List<Integer> generateRandomNumber() {
        ArrayList<Integer> candidate = new ArrayList<>();
        while (candidate.size() < 3) {
            insertDistinctNumber(candidate);
        }
        return candidate;
    }

    private static void insertDistinctNumber(List<Integer> candidate) {
        int newCandidate = (int) ((Math.random() * 8) + 1);
        while (candidate.contains(newCandidate)) {
            newCandidate = (int) ((Math.random() * 8) + 1);
        }
        candidate.add(newCandidate);
    }
}
