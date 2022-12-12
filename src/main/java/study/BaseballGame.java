package study;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseballGame {

    private final String answer;
    public BaseballGame() {
        Set<Integer> hashSet = new HashSet<Integer>();
        String numbers = "";
        int DIGITS = 3;
        for (int i =0; i<DIGITS; i++) {
            numbers += generateNumber(hashSet);
        }
        answer = numbers;
    }

    private String generateNumber(Set<Integer> hashSet) {
        Random random = new Random();
        int phase = hashSet.size();
        int randomNum = -1;
        while (phase == hashSet.size()) {
            randomNum = random.nextInt(8) + 1; // 1 ~ 9까지의 숫자 1개 추출
            hashSet.add(randomNum);
        }
        return Integer.toString(randomNum);
    }
}
