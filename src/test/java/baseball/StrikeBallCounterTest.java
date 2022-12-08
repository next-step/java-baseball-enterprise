package baseball;

import baseball.dto.StrikeBallCount;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StrikeBallCounterTest {

    @Test
    void countStrikeAndBall() {
        //given
        List<Integer> computerNum = Arrays.asList(1, 3, 5);

        List<Integer> playerNum1 = Arrays.asList(1, 2, 3); //1 strike 1 ball
        List<Integer> playerNum2 = Arrays.asList(1, 3, 5); //3 strike
        List<Integer> playerNum3 = Arrays.asList(6, 7, 8); //nothing
        List<Integer> playerNum4 = Arrays.asList(5, 1, 3); //3 ball

        //when
        StrikeBallCount strikeBallCount1 = StrikeBallCounter.countStrikeAndBall(computerNum, playerNum1);
        StrikeBallCount strikeBallCount2 = StrikeBallCounter.countStrikeAndBall(computerNum, playerNum2);
        StrikeBallCount strikeBallCount3 = StrikeBallCounter.countStrikeAndBall(computerNum, playerNum3);
        StrikeBallCount strikeBallCount4 = StrikeBallCounter.countStrikeAndBall(computerNum, playerNum4);

        //then
        System.out.println(strikeBallCount1);
        assertThat(strikeBallCount1.getStrikeCnt()).isEqualTo(1);
        assertThat(strikeBallCount1.getBallCnt()).isEqualTo(1);

        System.out.println(strikeBallCount2);
        assertThat(strikeBallCount2.getStrikeCnt()).isEqualTo(3);
        assertThat(strikeBallCount2.getBallCnt()).isZero();

        System.out.println(strikeBallCount3);
        assertThat(strikeBallCount3.getStrikeCnt()).isZero();
        assertThat(strikeBallCount3.getBallCnt()).isZero();

        System.out.println(strikeBallCount4);
        assertThat(strikeBallCount4.getStrikeCnt()).isZero();
        assertThat(strikeBallCount4.getBallCnt()).isEqualTo(3);
    }
}