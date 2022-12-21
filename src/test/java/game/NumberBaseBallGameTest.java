package game;

import domain.ballnumber.BallNumber;
import domain.ballnumber.generator.BallNumberGenMode;
import domain.game.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumberBaseBallGameTest {

    @Test
    @DisplayName("정답시 게임 중지 테스트")
    public void correctNumberGameStopTest() {
        //given
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(BallNumberGenMode.RANDOM);

        //when
        numberBaseBallGame.throwBall(numberBaseBallGame.getCorrectBallNumber());

        //then
        assertEquals(numberBaseBallGame.getGameStatus(), GameStatus.FINISH);
    }

    @Test
    @DisplayName("오답시 게임 계속 진행 테스트")
    public void wrongNumberGameKeepGoingTest() {
        //given
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(BallNumberGenMode.RANDOM);

        //when
        numberBaseBallGame.throwBall(new BallNumber(List.of(1,1,1)));

        //then
        assertEquals(numberBaseBallGame.getGameStatus(), GameStatus.PLAYING);
    }
}
