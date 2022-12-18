package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import num3baseball.dataobject.NumBallsNBalls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
}
