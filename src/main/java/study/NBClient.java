package study;

import java.util.Scanner;

public class NBClient {
    private static final int NUM_LENGTH = 3;

    /*
        숫자 야구에 사용 가능한 String 인지 확인한다.
     */
    private static Boolean check_valid_data(String str) {
        return str.length() == NUM_LENGTH && Integer.parseInt(str) >= 111 && Integer.parseInt(str) <= 999;
    }

    private static String get_input_string() {
        Scanner sc = new Scanner(System.in);
        String in;
        do {
            in = sc.nextLine();
        } while (!check_valid_data(in));

        return in;
    }

    public static void main(String[] args) {
        NumberBaseball nb = new NumberBaseball();
        nb.set_random_number(NUM_LENGTH);
        System.out.println("pass: " + get_input_string());
    }
}
