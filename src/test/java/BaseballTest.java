import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    @AfterEach
    void tearDown() {
    }

    @Test
    void isNumeric() {
        String true_test = "123";
        String false_test = "12a";
        Baseball bsb = new Baseball(3);

        assertTrue(bsb.isNumeric(true_test));
        assertFalse(bsb.isNumeric(false_test));
    }

    @Test
    void str_to_arr() {
        String test = "123";
        int[] answer = {1, 2, 3};
        Baseball bsb = new Baseball(3);

        assertArrayEquals(bsb.str_to_arr(test), answer);
    }

    @Test
    void zero_contain() {
        int[] true_test = {1, 0, 2};
        int[] false_test = {5, 6, 7};
        Baseball bsb = new Baseball(3);

        assertTrue(bsb.zero_contain(true_test));
        assertFalse(bsb.zero_contain(false_test));
    }

    @Test
    void isDuplicate() {
        int[] true_test = {1, 3, 1};
        int[] false_test = {5, 6, 7};
        Baseball bsb = new Baseball(3);

        assertTrue(bsb.isDuplicate(true_test));
        assertFalse(bsb.isDuplicate(false_test));
    }

    @Test
    void strike_msg() {
        int test_1 = 5;
        int test_2 = 0;
        String answer_1 = "5스트라이크 ";
        String answer_2 = "";
        Baseball bsb = new Baseball(3);

        assertEquals(bsb.strike_msg(test_1), answer_1);
        assertEquals(bsb.strike_msg(test_2), answer_2);
    }

    @Test
    void ball_msg() {
        int test_1 = 3;
        int test_2 = 0;
        String test_str_1 = "5스트라이크 ";
        String test_str_2 = "";
        String answer_1 = "5스트라이크 3볼";
        String answer_2 = "5스트라이크 ";
        String answer_3 = "3볼";
        String answer_4 = "";
        Baseball bsb = new Baseball(3);

        assertEquals(bsb.ball_msg(test_1, test_str_1), answer_1);
        assertEquals(bsb.ball_msg(test_2, test_str_1), answer_2);
        assertEquals(bsb.ball_msg(test_1, test_str_2), answer_3);
        assertEquals(bsb.ball_msg(test_2, test_str_2), answer_4);
    }

    @Test
    void result_msg() {
        String test_1 = "";
        String test_2 = "5스트라이크 ";
        String test_3 = "3볼";
        String test_4 = "5스트라이크 3볼";
        String answer_1 = "낫싱";
        String answer_2 = "5스트라이크";
        String answer_3 = "3볼";
        String answer_4 = "5스트라이크 3볼";
        Baseball bsb = new Baseball(3);

        assertEquals(bsb.result_msg(test_1), answer_1);
        assertEquals(bsb.result_msg(test_2), answer_2);
        assertEquals(bsb.result_msg(test_3), answer_3);
        assertEquals(bsb.result_msg(test_4), answer_4);
    }
}