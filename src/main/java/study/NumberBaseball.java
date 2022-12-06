package study;

import java.util.Random;

public class NumberBaseball {
    String computer_number = null;
    /*
        기능 1.
        len 자리수를 가지고, 1~9중의 숫자를 나타내는 무작위 String 저장.
     */
    public void set_random_number(int len) {
        Random random = new Random();
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < len; i++)
            ret.append(random.nextInt(9) + 1);
        computer_number = ret.toString();
    }

    public String get_random_number() {
        return computer_number;
    }
}
