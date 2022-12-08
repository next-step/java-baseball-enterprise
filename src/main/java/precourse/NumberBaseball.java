package precourse;

import java.util.Random;
import java.util.HashSet;
import java.util.Scanner;

public class NumberBaseball {
    private static final int TARGET_LENGTH = 3;
    private static final int BOUND = 9;
    private static final String ZERO = "0";
    private static final int STRIKE = 0;
    private static final int BALL = 1;
    private static final int THREE_STRIKE = 3;
    private static final boolean CONTINUE = true;
    private static final boolean QUIT = false;
    private static final boolean SUCCESS = true;
    private static final boolean FAIL = false;
    private static final int RESTART = 1;

    private String target;

    public String getTarget() {
        return this.target;
    }
    public void setTarget() {
        this.target = this.makeRandomThreeNumber();
    }

    public String makeRandomThreeNumber() {
        String number = "";
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        while (number.length() < TARGET_LENGTH) {
            int numInt = rand.nextInt(BOUND);
            String numStr = Integer.toString(numInt);
            number += this.checkValidNumber(numStr, number);
        }
        return number;
    }

    public String checkValidNumber(String num, String tmp) {
        if (num.equals(ZERO) || tmp.contains(num)) {
            return "";
        }
        return num;
    }

    public boolean examine(String ans) {
        int[] result = {0, 0}; // 0 : strike, 1 :  ball
        for (int i = 0; i < TARGET_LENGTH; i++) {
            this.examineUnit(i, ans.substring(i, i+1), result);
        }
        printResult(result);
        if (result[STRIKE] == THREE_STRIKE) {
            return SUCCESS;
        }
        return FAIL;
    }

    public void examineUnit(int numIndex, String num, int[] result) {
        if (this.target.indexOf(num) == numIndex) {
            result[STRIKE]++;
            return;
        }
        if (this.target.contains(num)) {
            result[BALL]++;
        }
    }

    public void printResult(int[] result) {
        if (result[STRIKE] == 0 && result[BALL] == 0) {
            System.out.println("낫싱");
            return;
        }
        if (result[BALL] == 0) {
            System.out.println(String.format("%d 스트라이크", result[STRIKE]));
            return;
        }
        if (result[STRIKE] == 0) {
            System.out.println(String.format("%d 볼", result[BALL]));
            return;
        }
        System.out.println(String.format("%d 스트라이크 %d 볼", result[STRIKE], result[BALL]));
    }

    public String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String s = scanner.next();
        while (!this.checkInput(s)) {
            System.out.println("잘못된 입력입니다. 1에서 9까지의 서로 다른 세개의 숫자를 입력해주세요.");
            System.out.print("숫자를 입력해주세요 : ");
            s = scanner.next();
        }
        return s;
    }

    public boolean checkInput(String input) {
        HashSet<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            set.add(c);
        }
        return !(input.length() != TARGET_LENGTH || input.contains(ZERO) || set.size() != TARGET_LENGTH);
    }

    public boolean restartGame() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt() == RESTART;
    }

    public void newGame() {
        this.setTarget();
        boolean over = QUIT;
        while (!over) {
            String input = this.input();
            over = this.examine(input);
        }
    }

    public static void main(String[] args) {
        NumberBaseball nb = new NumberBaseball();
        boolean play = CONTINUE;
        while (play) {
            nb.newGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            play = nb.restartGame();
        }
        System.out.println("게임을 종료합니다.");
    }
}
