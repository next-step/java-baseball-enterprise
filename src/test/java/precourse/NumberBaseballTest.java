package precourse;

import org.junit.jupiter.api.Test;

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
        HashSet<Character> set = new HashSet<>();
        for (char ch : nb.getTarget().toCharArray()) {
            set.add(ch);
        }
        assertThat(set).hasSize(3);
    }

    @Test
    void examine() {
        NumberBaseball nb = new NumberBaseball();
        nb.setTarget();

        assertThat(nb.examine(nb.getTarget())).isTrue();
        assertThat(nb.examine("111")).isFalse();
        assertThat(nb.examine("012")).isFalse();
        assertThat(nb.examine("999")).isFalse();
    }
}