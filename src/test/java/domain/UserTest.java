package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class UserTest {
    @Test
    @DisplayName("중복되지 않는 숫자 테스트")
    void testUniqueness(){
        User user = new User();
        user.setNumbers("123");
        String actual = user.getNumbers().toString();
        assertThat(actual).isEqualTo("[1, 2, 3]");
    }

    @Test
    @DisplayName("숫자 중복 입력")
    void testNotUniqueness(){
        User user = new User();
        String actual = "";
        user.reset();
        try {
            user.setNumbers("112");
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }
        assertThat(actual).isEqualTo("잘못된 입력입니다.");
    }

    @Test
    @DisplayName("숫자 초과 입력")
    void testOverNumber(){
        User user = new User();
        String actual = "";
        user.reset();
        try {
            user.setNumbers("1234");
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }
        assertThat(actual).isEqualTo("잘못된 입력입니다.");
    }
    @Test
    @DisplayName("문자 입력")
    void testChar(){
        User user = new User();
        String actual = "";
        user.reset();
        try {
            user.setNumbers("a12");
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }
        assertThat(actual).isEqualTo("잘못된 입력입니다.");
    }

}
