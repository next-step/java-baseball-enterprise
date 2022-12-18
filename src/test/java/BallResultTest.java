import config.GlobalData;
import domain.ballnumber.BallNumber;
import domain.ballnumber.BallResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class BallResultTest {

    @Test
    @DisplayName("추측한 숫자에 대한 전체 스트라이크 테스트")
    public void checkAllStrike(){
        //given
        BallNumber correctBallNumber = new BallNumber(new ArrayList<>(List.of(5,3,7)));
        BallNumber guessedBallNumber = new BallNumber(new ArrayList<>(List.of(5,3,7)));

        // when
        BallResult ballResult = BallResult.createBallResult(correctBallNumber,guessedBallNumber);

        //then
        assertTrue(ballResult.isAllStrike());
    }

    @Test
    @DisplayName("추측한 숫자에 대한 전체 볼 테스트")
    public void checkAllBall(){
        //given
        BallNumber correctBallNumber = new BallNumber(new ArrayList<>(List.of(5,3,7)));
        BallNumber guessedBallNumber = new BallNumber(new ArrayList<>(List.of(7,5,3)));

        // when
        BallResult ballResult = BallResult.createBallResult(correctBallNumber,guessedBallNumber);

        //then
        assertEquals(ballResult.getBall(), GlobalData.BALL_NUMBER_LENGTH);
    }

    @Test
    @DisplayName("추측한 숫자에 대한 1 스트라이크 2볼 테스트")
    public void check1Strike2Ball(){
        //given
        BallNumber correctBallNumber = new BallNumber(new ArrayList<>(List.of(5,3,7)));
        BallNumber guessedBallNumber = new BallNumber(new ArrayList<>(List.of(7,3,5)));

        // when
        BallResult ballResult = BallResult.createBallResult(correctBallNumber,guessedBallNumber);

        //then
        assertEquals(ballResult.getStrike(),1);
        assertEquals(ballResult.getBall(),2);
    }

    @Test
    @DisplayName("추측한 숫자에 대한 전체 불일치 테스트")
    public void checkNothing(){
        //given
        BallNumber correctBallNumber = new BallNumber(new ArrayList<>(List.of(5,3,7)));
        BallNumber guessedBallNumber = new BallNumber(new ArrayList<>(List.of(1,9,2)));

        // when
        BallResult ballResult = BallResult.createBallResult(correctBallNumber,guessedBallNumber);

        //then
        assertEquals(ballResult.getStrike(),0);
        assertEquals(ballResult.getBall(),0);
    }
}
