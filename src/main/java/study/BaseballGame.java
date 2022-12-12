package study;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {

    private final String answer;
    private final int DIGITS;

    public BaseballGame() {
        DIGITS = 3;
        answer = generateAnswer();
    }
    private String generateAnswer() {
        Set<Integer> hashSet = new HashSet<Integer>();
        String numbers = "";
        for (int i =0; i<DIGITS; i++) {
            numbers += generateNumber(hashSet);
        }
        return numbers;
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

    public void getUserInput() {
        System.out.println("숫자를 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        boolean result = validateUserInput(userInput);
        scanner.close();
    }

    private boolean validateUserInput(String userInput) {
        if (!validate_length(userInput)) {
            throw new IllegalArgumentException("입력이 3자리가 아닙니다.");
        }
        else if (!validate_consistOfNumbers(userInput)) {
            throw new IllegalArgumentException("입력이 숫자로 구성돼있지 않습니다.");
        }
        else if (!validate_duplicateNumbers(userInput)) {
            throw new IllegalArgumentException("중복된 숫자가 입력됐습니다.");
        }
        return true;
    }

    private boolean validate_duplicateNumbers(String userInput) {
        Set<Character> hashSet = new HashSet<Character>();
        for(int i =0; i<userInput.length(); i++) {
            hashSet.add(userInput.charAt(i));
        }
        return hashSet.size() == DIGITS;
    }


    private boolean validate_length(String UserInput) {
        return UserInput.length() == DIGITS;
    }
    private boolean validate_consistOfNumbers(String userInput) {

        int flag = 1;
        for(int i = 0; i < userInput.length(); i++) {
            flag *= validate_number(userInput.charAt(i));
        }
        return flag == 1;
    }
    private int validate_number(char c) {
        if (c >= '1' && c <= '9')
            return 1;
        return 0;
    }
}
