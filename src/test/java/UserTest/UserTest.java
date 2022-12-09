package UserTest;

import User.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class UserTest {
    @Test
    void setNumbersTest() {
        User user = new User();

        user.setNumbers("312");
        assertThat(user.getNumbers().size()).isEqualTo(3);
        assertThat(user.getNumbers()).containsExactly(3,1,2);
        user.setNumbers("4312");
        assertThat(user.getNumbers().size()).isEqualTo(4);
        assertThat(user.getNumbers()).containsExactly(4,3,1,2);
        user.setNumbers("02");
        assertThat(user.getNumbers().size()).isEqualTo(2);
        assertThat(user.getNumbers()).containsExactly(0,2);
    }
}
