package study;

import java.util.Random;

public class NumberBaseball {
    String computer_number = null;

    /*
        배열에서 두 index 의 value 를 바꾸는 함수.
     */
    private void switch_values(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /*
        기능 1.
        len 자리수를 가지고, 1~9중의 서로 다른 숫자를 나타내는 무작위 String 저장.
     */
    public void set_random_number(int len) {
        Random random = new Random();
        StringBuilder ret = new StringBuilder();
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int rand_index;

        for (int i = 0; i < len; i++) {
            rand_index = random.nextInt(ints.length-i-1);
            ret.append(ints[rand_index]);
            switch_values(ints, ints.length-i-1, rand_index);
        }
        computer_number = ret.toString();
    }

    public String get_random_number() {
        return computer_number;
    }
}
