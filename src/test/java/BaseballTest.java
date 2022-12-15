import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    @Test
    @DisplayName("게임을 시작하면 1에서 9까지 서로 다른 임의의 수 3개가 생성된다.")
    void create3Number() {
        Set<Integer> numbers = new LinkedHashSet<>();
        Random random = new Random();

        while (numbers.size() < 3) {
            numbers.add(random.nextInt(10));
        }

        assertThat(numbers.size()).isEqualTo(3);
    }
}