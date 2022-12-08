package UserTest;

import User.User;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class UserTest {
    @Test
    void setNumbersTest() {
        User user = new User();

        System.setIn(new ByteArrayInputStream("312".getBytes()));
        user.setNumbers();

        assertThat(user.getNumbers().size()).isEqualTo(3);
    }
}
