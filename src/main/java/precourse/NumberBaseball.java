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
}
