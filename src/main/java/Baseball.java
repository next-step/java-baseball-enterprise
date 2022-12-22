import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.lang.String;

public class Baseball {
    int length;

    Baseball(int ans_length) {
        length = ans_length;
    }
    // print input message
    void print_input_msg() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    // scan input integer
    int[] scan_input_num() {
        Scanner sc = new Scanner(System.in);

        return verify_input_num(sc.nextLine());
    }

    // verify input integer
    int[] verify_input_num(String input_line) {
        Scanner sc = new Scanner(System.in);
        int[] input_arr = isNumeric(input_line) ? str_to_arr(input_line) : new int[0];

        while (input_arr.length != length || zero_contain(input_arr) || isDuplicate(input_arr)) {
            System.out.printf("1~9사이의 중복되지 않은 숫자로 이루어진 %d자리 정수를 입력해주세요%n", length);
            print_input_msg();

            String tmp = sc.nextLine();
            input_arr = isNumeric(tmp) ? str_to_arr(tmp) : new int[0];
        }

        return input_arr;
    }

    // check whether input is integer
    boolean isNumeric(String input) { return input != null && input.matches("[1-9]+"); }

    // string to int array
    int[] str_to_arr(String input) {
        int[] input_arr = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            input_arr[i] = input.charAt(i) - '0';
        }

        return input_arr;
    }

    // return whether input integer contains zero
    boolean zero_contain(int[] input_arr) {
        int result = 1;

        for (int i : input_arr) {
            result *= i;
        }

        return result == 0;
    }

    // verify input number duplication
    boolean isDuplicate(int[] input_arr) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (input_arr[i] == input_arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // print result of compare & return end or not
    boolean compare_result(int[] result) {
        if (result[0] == length) {
            return true;
        }

        System.out.println(result_msg(ball_msg(result[1], strike_msg(result[0]))));

        return false;
    }

    // add number of strikes to result message
    String strike_msg(int strike_num) {
        String msg = "";

        if (strike_num != 0) {
            msg += String.format("%d스트라이크 ", strike_num);
        }

        return msg;
    }

    // add number of balls to result message
    String ball_msg(int ball_num, String msg) {
        if (ball_num != 0) {
            msg += String.format("%d볼", ball_num);
        }

        return msg;
    }

    // add 'nothing' message if there is no strike and ball
    String result_msg(String msg) {
        if (msg.length() == 0) {
            msg += "낫싱";
        }

        return msg.trim();
    }

    // print end message of game & return end type
    int end() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n", length);
        System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");

        return verify_end_type(sc.nextLine());
    }

    // verify end input
    int verify_end_type(String end_input) {
        Scanner sc = new Scanner(System.in);
        int end_type = isNumeric(end_input) ? Integer.parseInt(end_input) : 0;

        while (end_type != 1 && end_type != 2) {
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");

            String tmp = sc.nextLine();
            end_type = isNumeric(tmp) ? Integer.parseInt(tmp) : 0;
        }

        return end_type;
    }

    // baseball game
    void bsb_game() {
        int end_type = 1;

        while (end_type == 1) {
            Computer comp = new Computer(length);
            comp.print_answer();

            main_game(comp);

            end_type = end();
        }
    }

    // main game part
    void main_game(Computer comp) {
        boolean is_end = false;

        while (!is_end) {
            int[] result = new int[2];

            print_input_msg();
            comp.compare(scan_input_num(), result);

            is_end = compare_result(result);
        }
    }

    // main function
    public static void main(String[] args) {
        Baseball bsb = new Baseball(3);

        bsb.bsb_game();
    }
}

class Computer {
    int length;
    int[] answer;
    Random random = new Random(System.nanoTime());

    Computer(int ans_length) {
        length = ans_length;
        answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = random.nextInt(9) + 1;

            for (int j = 0; j < i; j++) {
                if (answer[i] == answer[j]) {
                    i--;
                    break;
                }
            }
        }
//        answer = new int[] {4, 5, 4};
    }

    // print answer
    void print_answer() {
        System.out.println(Arrays.toString(answer));
    }

    // compare input with answer
    void compare(int[] input_arr, int[] result) {

        result[0] = count_strike(input_arr);
        result[1] = count_ball(input_arr);
    }

    // return ball count
    int count_ball(int[] input_arr) {
        int ball_cnt = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                ball_cnt += i != j && input_arr[i] == answer[j] ? 1 : 0;
            }
        }

        return ball_cnt;
    }

    // return strike count
    int count_strike(int[] input_arr) {
        int strike_cnt = 0;

        for (int i = 0; i < length; i++) {
            strike_cnt += isStrike(input_arr[i], i);
        }

        return strike_cnt;
    }

    // return whether strike
    int isStrike(int input_elem, int order_num) {
        return answer[order_num] == input_elem ? 1 : 0;
    }
}
