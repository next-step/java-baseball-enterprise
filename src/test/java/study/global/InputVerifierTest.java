package study.global;

import global.model.InputVerifier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputVerifierTest {
    static private InputVerifier verifier;

    @BeforeAll
    static void init() {
        verifier = InputVerifier.getInstance();
    }

    @Test
    public void isIntegerWithLengthTest() {
        String s0 = "123";
        assertThat(verifier.isIntegerWithLength(s0, 3)).isEqualTo(true);

        String s1 = "";
        assertThat(verifier.isIntegerWithLength(s1, 3)).isEqualTo(false);

        String s2 = "a33";
        assertThat(verifier.isIntegerWithLength(s2, 3)).isEqualTo(false);

        String s3 = "1234";
        assertThat(verifier.isIntegerWithLength(s3, 3)).isEqualTo(false);

        String s4 = "";
        assertThat(verifier.isIntegerWithLength(s4, 0)).isEqualTo(false);
    }

    @Test
    public void hasZeroTest() {
        String s0 = "123";
        assertThat(verifier.hasZero(s0)).isEqualTo(false);

        String s1 = "";
        assertThat(verifier.hasZero(s1)).isEqualTo(false);

        String s2 = "a330";
        assertThat(verifier.hasZero(s2)).isEqualTo(true);

        String s3 = "Zero";
        assertThat(verifier.hasZero(s3)).isEqualTo(false);

        String s4 = "9999999999";
        assertThat(verifier.hasZero(s4)).isEqualTo(false);
    }
}
