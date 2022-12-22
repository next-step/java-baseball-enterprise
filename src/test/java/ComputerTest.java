import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void count_ball() {
        int[] bsb_answer = {4, 9, 6};
        int[] test_1 = {1, 2, 3};
        int[] test_2 = {1, 2, 4};
        int[] test_3 = {9, 2, 4};
        int[] test_4 = {9, 6, 4};
        int answer_1 = 0;
        int answer_2 = 1;
        int answer_3 = 2;
        int answer_4 = 3;
        Computer cmp = new Computer(3);
        cmp.set_answer(bsb_answer);

        assertEquals(cmp.count_ball(test_1), answer_1);
        assertEquals(cmp.count_ball(test_2), answer_2);
        assertEquals(cmp.count_ball(test_3), answer_3);
        assertEquals(cmp.count_ball(test_4), answer_4);
    }

    @Test
    void count_strike() {
        int[] bsb_answer = {4, 9, 6};
        int[] test_1 = {1, 2, 3};
        int[] test_2 = {4, 2, 3};
        int[] test_3 = {4, 2, 6};
        int[] test_4 = {4, 9, 6};
        int answer_1 = 0;
        int answer_2 = 1;
        int answer_3 = 2;
        int answer_4 = 3;
        Computer cmp = new Computer(3);
        cmp.set_answer(bsb_answer);

        assertEquals(cmp.count_strike(test_1), answer_1);
        assertEquals(cmp.count_strike(test_2), answer_2);
        assertEquals(cmp.count_strike(test_3), answer_3);
        assertEquals(cmp.count_strike(test_4), answer_4);
    }

    @Test
    void isStrike() {
        int[] bsb_answer = {4, 9, 6};
        int order_num = 0;
        int test_1 = 5;
        int test_2 = 4;
        int answer_1 = 0;
        int answer_2 = 1;
        Computer cmp = new Computer(3);
        cmp.set_answer(bsb_answer);

        assertEquals(cmp.isStrike(test_1, order_num), answer_1);
        assertEquals(cmp.isStrike(test_2, order_num), answer_2);
    }
}