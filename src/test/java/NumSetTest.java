import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.*;

class NumSetTest {
    @Test
    void convertToList() {
        assertThat(NumSet.convertToList(123)).isEqualTo(new int[]{1, 2, 3});
        assertThat(NumSet.convertToList(719)).isEqualTo(new int[]{7, 1, 9});
    }

    @Test
    void generateRandom3Number() throws NoSuchFieldException, IllegalAccessException {
        Field numArrField = NumSet.class.getDeclaredField("numArr");
        numArrField.setAccessible(true);

        for (int i = 0; i < 200; i++) {
            NumSet numSet = new NumSet();
            int[] numArr = (int[]) numArrField.get(numSet);

            assertThat(numArr[0]).isBetween(1, 9);
            assertThat(numArr[1]).isBetween(1, 9);
            assertThat(numArr[2]).isBetween(1, 9);

            assertThat(numArr[0]).isNotEqualTo(numArr[1]);
            assertThat(numArr[1]).isNotEqualTo(numArr[2]);
            assertThat(numArr[2]).isNotEqualTo(numArr[0]);
        }
    }


    @ParameterizedTest
    @CsvSource({"1,2,3,3,0", "1,3,2,1,2", "1,2,4,2,0", "4,5,1,0,1", "4,5,6,0,0"})
    void match(int userNum1, int userNum2, int userNum3, int strikeExpected, int ballExpected) throws NoSuchFieldException, IllegalAccessException {
        Field numArrField = NumSet.class.getDeclaredField("numArr");
        numArrField.setAccessible(true);

        NumSet numSet = new NumSet();
        numArrField.set(numSet, new int[]{1, 2, 3});

        Field strikeField = MatchResult.class.getDeclaredField("strike");
        strikeField.setAccessible(true);

        Field ballField = MatchResult.class.getDeclaredField("ball");
        ballField.setAccessible(true);

        MatchResult matchResult = numSet.match(new int[]{userNum1, userNum2, userNum3});
        int strike = strikeField.getInt(matchResult);
        int ball = ballField.getInt(matchResult);

        assertThat(strike).isEqualTo(strikeExpected);
        assertThat(ball).isEqualTo(ballExpected);
    }
}