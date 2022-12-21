import org.junit.jupiter.api.Test;

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
}