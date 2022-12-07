package study;

import java.util.Random;

public class NumberBaseball {
    private String computer_number = null;
    private final int STRIKE = 0;
    private final int BALL = 1;

    public String get_computer_number() { return computer_number; }
    public void set_computer_number(String computer_number) { this.computer_number = computer_number; }

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
        서로 다른 숫자임을 보장하기 위해 1~9 숫자 배열을 활용함.
        이미 있는 숫자인지 확인하는 방법도 고려하였으나, 둘다 장단점이 있는 듯 합니다.
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

    /*
        두 문자열을 비교하여 스트라이크/볼 숫자를 세서 반환한다.
        반환은 int 배열에 스트라이크, 볼 순서로 저장한다 -- 차라리 DTO 클래스 정의하는 것이 나을까?
     */
    public int[] compare_count(String user_number) {
        int[] count = {0, 0};

        for (int i = 0; i < user_number.length(); i++)
            _compare_count(user_number.charAt(i), i, count);
        return count;
    }

    private void _compare_count(char num, int index, int[] count) {
        if (computer_number.charAt(index) == num) {
            count[STRIKE] += 1;
            return;
        }

        if (computer_number.contains(String.valueOf(num))) {
            count[BALL] += 1;
            return;
        }
    }
}
