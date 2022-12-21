import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class NumberBaseball {
    final int NUMBER_COUNT = 3;
    final int MAX_NUM = 9;
    final int MIN_NUM = 1;
    final int CONTINUE = 1;
    final int END = 2;
    int[] random_numbers = new int[NUMBER_COUNT];
    boolean[] random_numbers_count = new boolean[MAX_NUM + 1];
    int[] input_numbers = new int[NUMBER_COUNT];
    int strike;
    int ball;

    public void initialize_parameter(){
        Arrays.fill(random_numbers, 0);
        Arrays.fill(random_numbers_count, false);
        Arrays.fill(input_numbers, 0);
        strike = 0;
        ball = 0;
    }

    public void generate_random_numbers() {
        Integer[] numbers = new Integer[MAX_NUM + 1];
        Arrays.setAll(numbers, i -> i + 1);
        List<Integer> numberList = Arrays.asList(numbers);
        Collections.shuffle(numberList);
        for(int i = 0; i < NUMBER_COUNT; ++i){
            random_numbers[i] = numberList.get(i);
        }
    }

    public void get_input_numbers() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for(int i = 0; i < NUMBER_COUNT; ++i){
            input_numbers[i] = input.charAt(i) - '0';
        }
    }

    public void get_random_numbers_count() {
        for(int i = 0; i < NUMBER_COUNT; ++i){
            random_numbers_count[random_numbers[i]] = true;
        }
    }

    public void count_strike_or_ball(int idx) {
        if(random_numbers[idx] == input_numbers[idx]){
            ++strike;
            return;
        }
        if(random_numbers_count[input_numbers[idx]]){
            ++ball;
        }
    }

    public void get_game_result() {
        strike = 0;
        ball = 0;
        for(int i = 0; i < NUMBER_COUNT; ++i) {
            count_strike_or_ball(i);
        }
    }

    public void print_game_result() {
        if(strike > 0){
            System.out.print(strike + " 스트라이크 ");
        }
        if(ball > 0){
            System.out.print(ball + "볼");
        }
        if(strike == 0 && ball == 0){
            System.out.print("낫싱");
        }
        System.out.print("\n");
    }

    public boolean continue_or_end(int input){
        if (input == CONTINUE){
            return true;
        }
        if (input == END){
            return false;
        }
        return false;
    }

    public boolean print_end_message(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        return continue_or_end(input);
    }

    public boolean do_game() {
        initialize_parameter();
        generate_random_numbers();
        get_random_numbers_count();
        while(strike != NUMBER_COUNT) {
            get_input_numbers();
            get_game_result();
            print_game_result();
        }
        return print_end_message();
    }

    public static void main(String[] args) {
        NumberBaseball numberBaseball = new NumberBaseball();
        boolean game_continue = true;
        while(game_continue){
            game_continue = numberBaseball.do_game();
        }
    }
}
