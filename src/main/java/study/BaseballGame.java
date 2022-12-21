package study;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {

    private String answer;
    private final int DIGITS;

    public static void main(String[] args) {
        BaseballGame bg = new BaseballGame();
        bg.play();
    }

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

    public void play() {
        boolean flag = true;
        while(flag) {
            flag = playGame();
            answer = generateAnswer();
        }
    }

    private boolean playGame() {
        GameResultSet resultSet = new GameResultSet();
        while(!(resultSet.strike == DIGITS && resultSet.ball == 0)) {
            resultSet = proceedRound();
        }
        boolean flag = continueGame();
        return flag;
    }

    private boolean continueGame() {
        System.out.println("게임을 계속 계속하시겠습니까? (y / n)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if( input.equals("y") || input.equals("Y")) {
            return true;
        }
        return false;
    }


    public String getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        validateUserInput(userInput);
        return userInput;
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


    public GameResultSet proceedRound() {
        Set<Character> hashSet = generateAnswerSet();
        GameResultSet resultSet = new GameResultSet();
        try{
            String userInput = getUserInput();
            judgeNumbers(userInput, hashSet, resultSet);
            printScore(resultSet);
        }catch(IllegalArgumentException e) {
            System.out.println(e);
        }
        return resultSet;
    }

    private void judgeNumbers(String userInput, Set<Character> hashSet, GameResultSet resultSet) {
        for (int i = 0; i < userInput.length(); i++) {
            judgeOneNumber(userInput.charAt(i), answer.charAt(i), hashSet, resultSet);
        }
    }

    private Set<Character> generateAnswerSet() {
        Set<Character> hashSet = new HashSet<Character>();
        for (int i = 0; i < answer.length(); i++) {
            hashSet.add(answer.charAt(i));
        }
        return hashSet;
    }

    private void judgeOneNumber(char ui, char aw, Set<Character> hashSet, GameResultSet resultSet) {
        if (ui == aw) {
            resultSet.strike += 1;
        }
        else if (hashSet.contains(ui)) {
            resultSet.ball += 1;
        }
    }

    private void printScore(GameResultSet resultSet) {
        if (resultSet.strike != 0) {
            System.out.print(resultSet.strike + "스트라이크 ");
        }
        if (resultSet.ball != 0) {
            System.out.print(resultSet.ball + "볼");
        }
        else if (resultSet.strike == 0 && resultSet.ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    private boolean isCorrectAnswer(GameResultSet resultSet) {
        return resultSet.strike == DIGITS && resultSet.ball == 0;
    }
}
