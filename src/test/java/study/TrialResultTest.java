package study;

import num3baseball.dataobject.TrialResult;
import num3baseball.exception.WrongNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TrialResultTest {
    @ParameterizedTest
    @CsvSource(value = {"12:false", "30:false", "21:true", "22:true", "00:false", "11:false", "01:false"}, delimiter = ':')
    @DisplayName("Check appropriately throw exception when strike and ball values are not valid")
    void TrialResultTest(int sb, boolean isthrown){
        final int size=3;
        int strike = sb/10;
        int ball = sb%10;
        if (isthrown){
            assertThatThrownBy(()->{
                TrialResult t = new TrialResult(strike, ball, size);
            }).isInstanceOf(WrongNumberException.class);
            assertThatThrownBy(()->{
                TrialResult t = new TrialResult(size);
                t.setStrikeBall(strike, ball);
            }).isInstanceOf(WrongNumberException.class);
        }
        else{
            assertThatCode(()->{
                TrialResult t = new TrialResult(strike, ball, size);
            }).doesNotThrowAnyException();
            assertThatCode(()->{
                TrialResult t = new TrialResult(size);
                t.setStrikeBall(strike, ball);
            }).doesNotThrowAnyException();
        }
    }
}
