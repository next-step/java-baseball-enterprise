package study;

import num3baseball.dataobject.Num3Balls;
import num3baseball.exception.WrongNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class Num3BallsTest {
    @Test
    @DisplayName("Check Randomly Generated Numbers")
    void isReallyRandom() {
        Set<Integer> generatedBalls = new HashSet<Integer>();
        int iterNum = 10;
        for (int i=1;i<=iterNum;i++){
            Num3Balls num3Balls = new Num3Balls();
            int ballNum = num3Balls.getNum1()*100 + num3Balls.getNum2()*10+ num3Balls.getNum3();
            generatedBalls.add(ballNum);
        }

        assertThat(generatedBalls.size()).isGreaterThan(iterNum*7/10);
        //적어도 10번을 돌렸을 때 7개의 다른 숫자가 생성된다
    }

    @Test
    @DisplayName("Check Randomly Generated Numbers Fits Condition")
    void isValidNumbers(){
        int iterNum = 10;
        for (int i=1;i<=iterNum;i++){
            Num3Balls num3Balls = new Num3Balls();
            assertThat(num3Balls.getNum1()).isGreaterThan(0).isLessThan(10);
            assertThat(num3Balls.getNum2()).isGreaterThan(0).isLessThan(10);
            assertThat(num3Balls.getNum3()).isGreaterThan(0).isLessThan(10);
        }
    }

    @ParameterizedTest
    @CsvSource(value={"123:false", "112:true", "320:true", "352:false", "121:true", "122:true"}, delimiter=':')
    @DisplayName("Check WrongNumberException is thrown appropriately")
    void throwAppropriately(int nums, boolean chkThrow){
        if (chkThrow){
            assertThatThrownBy(()->{
                Num3Balls num3Balls = new Num3Balls(nums/100,nums/10%10,nums%10);
            }).isInstanceOf(WrongNumberException.class);
        }
        else{
            assertThatCode(()->{
                Num3Balls num3Balls = new Num3Balls(nums/100,nums/10%10,nums%10);
            }).doesNotThrowAnyException();
        }
    }

}
