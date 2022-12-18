import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberBaseballTest {
    NumberBaseball numberBaseball = new NumberBaseball();

    void set_random_numbers() {
        numberBaseball.random_numbers[0] = 7;
        numberBaseball.random_numbers[1] = 1;
        numberBaseball.random_numbers[2] = 3;
    }

    void set_random_numbers_count() {
        numberBaseball.random_numbers_count[1] = true;
        numberBaseball.random_numbers_count[3] = true;
        numberBaseball.random_numbers_count[7] = true;
    }


    void set_input_numbers_same() {
        numberBaseball.input_numbers[0] = 7;
        numberBaseball.input_numbers[1] = 1;
        numberBaseball.input_numbers[2] = 3;
    }

    @Test
    void initialize_parameter_test() {
        numberBaseball.initialize_parameter();
        assertThat(numberBaseball.random_numbers).containsOnly(0, 0, 0);
        assertThat(numberBaseball.random_numbers_count).contains(false);
        assertThat(numberBaseball.input_numbers).containsOnly(0, 0, 0);
        assertThat(numberBaseball.strike).isEqualTo(0);
        assertThat(numberBaseball.ball).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void generate_random_numbers_test(int idx) {
        numberBaseball.generate_random_numbers();
        assertThat(numberBaseball.random_numbers[idx]).isGreaterThanOrEqualTo(numberBaseball.MIN_NUM);
        assertThat(numberBaseball.random_numbers[idx]).isLessThanOrEqualTo(numberBaseball.MAX_NUM);
    }


    @Test
    void get_random_numbers_count() {
        set_random_numbers();
        numberBaseball.get_random_numbers_count();
        assertThat(numberBaseball.random_numbers_count[1]).isEqualTo(true);
        assertThat(numberBaseball.random_numbers_count[3]).isEqualTo(true);
        assertThat(numberBaseball.random_numbers_count[7]).isEqualTo(true);
    }

    @Test
    void count_strike_test() {
        set_random_numbers();
        set_random_numbers_count();
        numberBaseball.input_numbers[0] = 7;
        numberBaseball.count_strike_or_ball(0);
        assertThat(numberBaseball.strike).isEqualTo(1);
        assertThat(numberBaseball.ball).isEqualTo(0);
    }

    @Test
    void count_ball_test() {
        set_random_numbers();
        set_random_numbers_count();
        numberBaseball.input_numbers[0] = 1;
        numberBaseball.count_strike_or_ball(0);
        assertThat(numberBaseball.strike).isEqualTo(0);
        assertThat(numberBaseball.ball).isEqualTo(1);
    }

    @Test
    void count_nothing_test() {
        set_random_numbers();
        set_random_numbers_count();
        numberBaseball.input_numbers[0] = 2;
        numberBaseball.count_strike_or_ball(0);
        assertThat(numberBaseball.strike).isEqualTo(0);
        assertThat(numberBaseball.ball).isEqualTo(0);
    }

    @Test
    void get_game_result_test() {
        set_random_numbers();
        set_input_numbers_same();
        numberBaseball.get_game_result();
        assertThat(numberBaseball.strike).isEqualTo(3);
        assertThat(numberBaseball.ball).isEqualTo(0);
    }
}
