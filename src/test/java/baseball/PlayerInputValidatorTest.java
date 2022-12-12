package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayerInputValidatorTest {

    @Test
    void validate_Integer로_변환() {
        PlayerInputValidator validator = new PlayerInputValidator();

        String str1 = "123";
        String str2 = "asdf 123";
        String str3 = "123 asdf";
        String str4 = "123asdf";
        String str5 = "       123";
        String str6 = "123     ";
        String str7 = "       123     ";
        String str8 = Long.MAX_VALUE + "";

        assertThat(validator.validateBaseballNumber(str1)).isTrue();
        assertThat(validator.validateBaseballNumber(str2)).isFalse();
        assertThat(validator.validateBaseballNumber(str3)).isFalse();
        assertThat(validator.validateBaseballNumber(str4)).isFalse();
        assertThat(validator.validateBaseballNumber(str5)).isFalse();
        assertThat(validator.validateBaseballNumber(str6)).isFalse();
        assertThat(validator.validateBaseballNumber(str7)).isFalse();
        assertThat(validator.validateBaseballNumber(str8)).isFalse();
    }

    @Test
    void validate_3자리_양의정수() {
        PlayerInputValidator validator = new PlayerInputValidator();

        String str1 = "123";
        String str2 = "1";
        String str3 = "12";
        String str4 = "1234";
        String str5 = "-1";
        String str6 = "-123";

        assertThat(validator.validateBaseballNumber(str1)).isTrue();
        assertThat(validator.validateBaseballNumber(str2)).isFalse();
        assertThat(validator.validateBaseballNumber(str3)).isFalse();
        assertThat(validator.validateBaseballNumber(str4)).isFalse();
        assertThat(validator.validateBaseballNumber(str5)).isFalse();
        assertThat(validator.validateBaseballNumber(str6)).isFalse();
    }

    @Test
    void validate_자리수_0_체크() {
        PlayerInputValidator validator = new PlayerInputValidator();

        String str1 = "123";
        String str2 = "120";
        String str3 = "102";

        assertThat(validator.validateBaseballNumber(str1)).isTrue();
        assertThat(validator.validateBaseballNumber(str2)).isFalse();
        assertThat(validator.validateBaseballNumber(str3)).isFalse();
    }

    @Test
    void validate_서로다른_자리수_체크() {
        PlayerInputValidator validator = new PlayerInputValidator();

        String str1 = "123";
        String str2 = "122";
        String str3 = "111";
        String str4 = "223";
        String str5 = "121";

        assertThat(validator.validateBaseballNumber(str1)).isTrue();
        assertThat(validator.validateBaseballNumber(str2)).isFalse();
        assertThat(validator.validateBaseballNumber(str3)).isFalse();
        assertThat(validator.validateBaseballNumber(str4)).isFalse();
        assertThat(validator.validateBaseballNumber(str5)).isFalse();
    }
}