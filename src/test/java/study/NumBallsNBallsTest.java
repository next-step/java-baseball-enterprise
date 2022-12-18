package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import num3baseball.dataobject.NumBallsNBalls;
import num3baseball.exception.WrongNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

public class NumBallsNBallsTest {
    @Test
    @DisplayName("Constructor(int size) - does not raise exception")
    void NumBallsNBallsTest1() {
        int iter = 10;
        for (int i=1;i<=iter;i++){
            assertThatCode(()->{
                NumBallsNBalls t = new NumBallsNBalls(3);
            }).doesNotThrowAnyException();
        }
    }
    @Test
    @DisplayName("Constructor(int size) - does not make duplicated one")
    void NumBallsNBallsTest2() {
        int iter = 10;
        int dupCount = 0;
        for (int i=1;i<=iter;i++){
            NumBallsNBalls t1 = new NumBallsNBalls(3);
            NumBallsNBalls t2 = new NumBallsNBalls(3);
            if (t1.getNum(0) == t2.getNum(0) && t1.getNum(1) == t2.getNum(1) && t1.getNum(2) == t2.getNum(2)){
                dupCount++;
            }
        }
        assertThat(dupCount<(iter*3/10)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"123:false", "121:true", "320:true", "335:true", "948:false", "191:true"}, delimiter = ':')
    @DisplayName("Constructor(ArrayList<Integer>) - raises exception(or not) appropriately")
    void NumBallsNBallsTest3(int num, boolean isThrown){
        if (isThrown){
            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(num/100);
            nums.add(num/10%10);
            nums.add(num%10);
            assertThatThrownBy(()->{
                NumBallsNBalls t = new NumBallsNBalls(nums);
            }).isInstanceOf(WrongNumberException.class);
        }
        else{
            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(num/100);
            nums.add(num/10%10);
            nums.add(num%10);
            assertThatCode(()->{
                NumBallsNBalls t = new NumBallsNBalls(nums);
            }).doesNotThrowAnyException();
        }
    }
}
