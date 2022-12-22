package baseballGame;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class BaseballGameTest {
    //정답, 유저정답, 스트라이크, 볼
    @Test
    void testAnswer() {
        BaseballTest baseballtest = new BaseballTest();
        int[] answer = baseballtest.testAnswer();
        for(int i = 0; i < 3; i++)
            assertThat(answer[i] >= 1 && answer[i] <= 9);
    }
    @Test
    void testStrike() {
        BaseballTest baseballtest = new BaseballTest();
        int[] answer = {1, 2, 3};
        int[] userAnswer = {1, 3, 5};
        int strike = baseballtest.testStrike(answer, userAnswer);
        assertThat(strike == 1);
        //스트라이크가 1맞는지
    }

    @Test
    void testBall() {
        BaseballTest baseballtest = new BaseballTest();
        int[] answer = {1, 2, 3};
        int[] userAnswer = {1, 3, 5};
        int ball = baseballtest.testBall(answer, userAnswer);
        assertThat(ball == 1);
        //볼이 1맞는지
    }
}
