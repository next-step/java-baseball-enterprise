package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberBaseballTest {
    final int NUM_LENGTH = 3;
    final int TEST_NUM = 100;

    boolean check_valid(String num) {
        int[] table = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < num.length(); i++) {
            int index = num.charAt(i)-'0'-1;
            if (table[index] == 1)
                return false;
            table[index] += 1;
        }
        return true;
    }

    @Test
    void random_number_test() {
        NumberBaseball nb = new NumberBaseball();

        for (int i = 0; i < TEST_NUM; i++) {
            nb.set_random_number(NUM_LENGTH);
            String random = nb.get_random_number();
            int random_ = Integer.parseInt(random);

            //System.out.println(random_);
            assert(check_valid(random));
            assertThat(random_).isGreaterThan(110).isLessThan(1000);
        }
    }
}
