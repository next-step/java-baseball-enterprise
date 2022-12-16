import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    private Set<Integer> numbers = new LinkedHashSet<>();
    private Set<Integer> numbers2 = new LinkedHashSet<>();

    @Test
    @DisplayName("게임을 시작하면 1에서 9까지 서로 다른 임의의 수 3개가 생성된다.")
    void create3Number() {
        numbers.clear();
        Random random = new Random();

        while (numbers.size() < 3) {
            numbers.add(random.nextInt(10));
        }

        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자에게 3개의 숫자를 입력 받는다.")
    void insert3Number() {
        Scanner sc = TestUtil.getScanner("123");
        String number = sc.nextLine();

        for (int i = 0; i < number.length(); i++)
        {
            numbers2.add(number.charAt(i) - '0');
        }

        assertThat(numbers2.size()).isEqualTo(3);
    }
}