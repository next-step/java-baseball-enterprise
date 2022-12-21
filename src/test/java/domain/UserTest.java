package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class UserTest {
    @ParameterizedTest
    @DisplayName("숫자 입력 테스트")
    @CsvSource(value = {"123;[1, 2, 3]",
            "112;잘못된 입력입니다.",
            "1234;잘못된 입력입니다.",
            "a12;잘못된 입력입니다."}, delimiter = ';')
    void testInput(String input,String expected){
        User user = new User();
        String actual;
        try {
            user.setNumbers(input);
            actual = user.getNumbers().toString();
        }catch (IllegalArgumentException e){
            actual = e.getMessage();
        }
        assertThat(actual).isEqualTo(expected);
    }

}
