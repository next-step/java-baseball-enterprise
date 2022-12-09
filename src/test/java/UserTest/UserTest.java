package UserTest;

import User.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class UserTest {
    @Test
    void setNumbersTest() {
        User user = new User();

        user.setNumbers("043012");
        assertThat(user.getNumbers()).containsExactly(0,4,3,0,1,2);
    }
}
