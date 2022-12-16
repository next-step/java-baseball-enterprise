public class NumberBaseball {
    final int NUMBER_COUNT = 3;
    final int MAX_NUM = 9;
    final int CONTINUE = 1;
    final int END = 2;
    int[] random_numbers = new int[NUMBER_COUNT];
    boolean[] random_numbers_count = new boolean[MAX_NUM + 1];
    int[] input_numbers = new int[NUMBER_COUNT];
    int strike;
    int ball;
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
