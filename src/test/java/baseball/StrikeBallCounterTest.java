package baseball;

import baseball.dto.StrikeBallCountDto;
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
        StrikeBallCountDto strikeBallCountDto1 = StrikeBallCounter.countStrikeAndBall(computerNum, playerNum1);
        StrikeBallCountDto strikeBallCountDto2 = StrikeBallCounter.countStrikeAndBall(computerNum, playerNum2);
        StrikeBallCountDto strikeBallCountDto3 = StrikeBallCounter.countStrikeAndBall(computerNum, playerNum3);
        StrikeBallCountDto strikeBallCountDto4 = StrikeBallCounter.countStrikeAndBall(computerNum, playerNum4);

        //then
        System.out.println(strikeBallCountDto1);
        assertThat(strikeBallCountDto1.getStrikeCnt()).isEqualTo(1);
        assertThat(strikeBallCountDto1.getBallCnt()).isEqualTo(1);

        System.out.println(strikeBallCountDto2);
        assertThat(strikeBallCountDto2.getStrikeCnt()).isEqualTo(3);
        assertThat(strikeBallCountDto2.getBallCnt()).isZero();

        System.out.println(strikeBallCountDto3);
        assertThat(strikeBallCountDto3.getStrikeCnt()).isZero();
        assertThat(strikeBallCountDto3.getBallCnt()).isZero();

        System.out.println(strikeBallCountDto4);
        assertThat(strikeBallCountDto4.getStrikeCnt()).isZero();
        assertThat(strikeBallCountDto4.getBallCnt()).isEqualTo(3);
    }
}