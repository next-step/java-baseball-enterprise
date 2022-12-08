package UserTest;

import User.User;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
public class UserTest {
    @Test
    void setNumbersTest() {
        User user = new User();

        user.setNumbers(312);

        assertThat(user.getNumbers().size()).isEqualTo(3);
    }
}
