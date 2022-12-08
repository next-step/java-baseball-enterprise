package study;

import java.util.Scanner;

public class NBClient {
    private static final Scanner sc = new Scanner(System.in);
    private static final int NUM_LENGTH = 3;
    private static final int STRIKE = 0;
    private static final int BALL = 1;

    /*
        숫자 야구에 사용 가능한 String 인지 확인한다.
     */
    private static Boolean check_valid_data(String str) {
        return str.length() == NUM_LENGTH && Integer.parseInt(str) >= 111 && Integer.parseInt(str) <= 999;
    }

    private static String get_user_number() {
        String in;
        do {
            System.out.print("숫자를 입력해주세요: ");
            in = sc.next();
        } while (!check_valid_data(in));

        return in;
    }

    private static int get_goStop() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return sc.nextInt();
    }

    private static void print_count(int[] count) {
        if (count[STRIKE] != 0)
            System.out.printf("%d 스트라이크 ", count[STRIKE]);
        if (count[BALL] != 0)
            System.out.printf("%d 볼", count[BALL]);
        System.out.print("\n");
    }

    private static void do_game(NumberBaseball nb) {
        int[] count = {0, 0};

        while (count[0] != NUM_LENGTH) {
            count = nb.compare_count(get_user_number());
            print_count(count);
        }
    }

    public static void main(String[] args) {
        NumberBaseball nb = new NumberBaseball();

        nb.set_random_number(NUM_LENGTH);
        do {
            do_game(nb);
        } while (get_goStop() == 1);
    }
}
