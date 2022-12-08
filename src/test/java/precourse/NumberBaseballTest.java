package precourse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class NumberBaseballTest {

    @Test
    void setTarget() {
        NumberBaseball nb = new NumberBaseball();
        nb.setTarget();
        assertThat(nb.getTarget().length()).isEqualTo(3);
        assertThat(!nb.getTarget().contains("0")).isTrue();
        HashSet<Character> repeatCheck = new HashSet<>();
        for (char ch : nb.getTarget().toCharArray()) {
            repeatCheck.add(ch);
        }
        assertThat(repeatCheck).hasSize(3);
    }

    @Test
    void examine() {
        NumberBaseball nb = new NumberBaseball();
        nb.setTarget();

        assertThat(nb.examine(nb.getTarget())).isTrue();
        assertThat(nb.examine("111")).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"123:true", "456:true", "012:false", "111:false", "1234:false", "1123:false", "12:false", "9:false", "434312:false"}, delimiter = ':')
    void checkInput(String input, boolean result) {
        NumberBaseball nb = new NumberBaseball();
        assertThat(nb.checkInput(input)).isEqualTo(result);
    }
}