package precourse;

import java.util.Random;

public class NumberBaseball {
    private String target;

    public String getTarget() {
        return this.target;
    }
    public void setTarget() {
        String tmp = "";
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        while (tmp.length() < 3) {
            int numInt = rand.nextInt(9);
            String numStr = Integer.toString(numInt);
            tmp += this.checkValidNumber(numStr, tmp);
        }
        this.target = tmp;
    }

    public String checkValidNumber(String num, String tmp) {
        if (num.equals("0") || tmp.contains(num)) {
            return "";
        }
        return num;
    }

    public boolean examine(String ans) {
        int[] result = {0, 0}; // 0 : strike, 1 :  ball
        for (int i = 0; i < 3; i++) {
            this.examineUnit(i, ans.substring(i, i+1), result);
        }
        printResult(result);
        if (result[0] == 3) {
            return true;
        }
        return false;
    }

    public void examineUnit(int i, String num, int[] result) {
        if (this.target.indexOf(num) == i) {
            result[0]++;
            return;
        }
        if (this.target.contains(num)) {
            result[1]++;
        }
    }

    public void printResult(int[] result) {
        if (result[0] == 3) {
            System.out.println("정답입니다!");
            return;
        }
        System.out.println(String.format("strike %d, ball %d", result[0], result[1]));
    }
}
