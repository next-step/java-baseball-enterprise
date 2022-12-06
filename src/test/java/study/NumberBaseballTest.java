package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberBaseballTest {
    @Test
    void random_number_test() {
        NumberBaseball nb = new NumberBaseball();
        nb.set_random_number(3);
        String random = nb.get_random_number();

        System.out.println(random);
        int random_ = Integer.parseInt(random);
        assertThat(random_).isGreaterThan(110).isLessThan(1000);
    }
}
