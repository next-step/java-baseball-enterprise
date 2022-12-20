package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class UserTest {
    @Test
    void create(){
        User user = new User();
        user.setNumbers("123");
        String actual = user.getNumbers().toString();
        assertThat(actual).isEqualTo("[1, 2, 3]");

        user.reset();
        try {
            user.setNumbers("111");
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }
        assertThat(actual).isEqualTo("잘못된 입력입니다.");
    }

}
