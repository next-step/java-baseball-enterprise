import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumSetTest {
    @Test
    void convertToList() {
        assertThat(NumSet.convertToList(123)).isEqualTo(new int[]{1, 2, 3});
        assertThat(NumSet.convertToList(719)).isEqualTo(new int[]{7, 1, 9});
    }
}