package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballRefereeImplTest {

    final BaseballReferee baseballReferee = new BaseballRefereeImpl();

    @Test
    @DisplayName("strike_success_test")
    void strikeSuccessTest() throws Exception {
        Method isStrike = BaseballRefereeImpl.class.getDeclaredMethod("isStrike", List.class, List.class, int.class);
        isStrike.setAccessible(true);
        boolean isStrikeResult = (boolean) isStrike.invoke(baseballReferee, List.of(1), List.of(1), 0);
        assertThat(isStrikeResult).isTrue();
    }

    @Test
    @DisplayName("strike_fail_test")
    void strikeFailTest() throws Exception {
        Method isStrike = BaseballRefereeImpl.class.getDeclaredMethod("isStrike", List.class, List.class, int.class);
        isStrike.setAccessible(true);
        boolean isStrikeResult = (boolean) isStrike.invoke(baseballReferee, List.of(1), List.of(2), 0);
        assertThat(isStrikeResult).isFalse();
    }

    @Test
    @DisplayName("ball_success_test")
    void ballSuccessTest() throws Exception {
        Method isBall = BaseballRefereeImpl.class.getDeclaredMethod("isBall", List.class, List.class, int.class);
        isBall.setAccessible(true);
        boolean isBallResult = (boolean) isBall.invoke(baseballReferee, List.of(1, 2), List.of(2, 1), 0);
        assertThat(isBallResult).isTrue();
    }

    @Test
    @DisplayName("ball_fail_test")
    void ballFailTest() throws Exception {
        Method isBall = BaseballRefereeImpl.class.getDeclaredMethod("isBall", List.class, List.class, int.class);
        isBall.setAccessible(true);
        boolean isBallResult = (boolean) isBall.invoke(baseballReferee, List.of(1, 2), List.of(3, 1), 0);
        assertThat(isBallResult).isFalse();
    }

    @Test
    @DisplayName("strike_check_test")
    void StrikeCheckTest() throws Exception {
        JudgeResult judgeResult = new JudgeResult(0, 0);
        Method checkBallAndStrike = BaseballRefereeImpl.class.getDeclaredMethod("checkBallAndStrike", List.class, List.class, int.class, JudgeResult.class);
        checkBallAndStrike.setAccessible(true);
        checkBallAndStrike.invoke(baseballReferee, List.of(1, 2), List.of(1, 3), 0, judgeResult);
        assertThat(judgeResult.getStrikesNum()).isEqualTo(1);
        assertThat(judgeResult.getBallNum()).isEqualTo(0);
    }

    @Test
    @DisplayName("ball_check_test")
    void BallCheckTest() throws Exception {
        JudgeResult judgeResult = new JudgeResult(0, 0);
        Method checkBallAndStrike = BaseballRefereeImpl.class.getDeclaredMethod("checkBallAndStrike", List.class, List.class, int.class, JudgeResult.class);
        checkBallAndStrike.setAccessible(true);
        checkBallAndStrike.invoke(baseballReferee, List.of(1, 2), List.of(2, 3), 0, judgeResult);
        assertThat(judgeResult.getStrikesNum()).isEqualTo(0);
        assertThat(judgeResult.getBallNum()).isEqualTo(1);
    }
    @Test
    @DisplayName("nothing_check_test")
    void NothingCheckTest() throws Exception {
        JudgeResult judgeResult = new JudgeResult(0, 0);
        Method checkBallAndStrike = BaseballRefereeImpl.class.getDeclaredMethod("checkBallAndStrike", List.class, List.class, int.class, JudgeResult.class);
        checkBallAndStrike.setAccessible(true);
        checkBallAndStrike.invoke(baseballReferee, List.of(1, 2), List.of(5, 3), 0, judgeResult);
        assertThat(judgeResult.getStrikesNum()).isEqualTo(0);
        assertThat(judgeResult.getBallNum()).isEqualTo(0);
    }
    @Test
    @DisplayName("judge_test_three_strikes")
    void judgeTestThreeStrikes(){
        JudgeResult judgeResult = baseballReferee.judge(List.of(1, 2, 3), List.of(1, 2, 3));
        assertThat(judgeResult.getStrikesNum()).isEqualTo(3);
        assertThat(judgeResult.getBallNum()).isEqualTo(0);
    }

    @Test
    @DisplayName("judge_test_one_strike_two_ball")
    void judgeTestOneStrikeAndTwoBall(){
        JudgeResult judgeResult = baseballReferee.judge(List.of(1, 4, 5), List.of(1, 5, 4));
        assertThat(judgeResult.getStrikesNum()).isEqualTo(1);
        assertThat(judgeResult.getBallNum()).isEqualTo(2);
    }



}