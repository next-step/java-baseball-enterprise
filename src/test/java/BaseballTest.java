import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {

    private Set<Integer> numbers = new LinkedHashSet<>();
    private Set<Integer> numbers2 = new LinkedHashSet<>();

    void init() {
        numbers = new LinkedHashSet<>();
        numbers2 = new LinkedHashSet<>();
    }
    @BeforeEach
    void setUp() {
        init();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        numbers2.add(3);
        numbers2.add(2);
        numbers2.add(1);
    }

    @Test
    @DisplayName("게임을 시작하면 1에서 9까지 서로 다른 임의의 수 3개가 생성된다.")
    void create3Number() {
        numbers.clear();
        Random random = new Random();

        while (numbers.size() < 3) {
            numbers.add(random.nextInt(9) + 1);
        }

        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자에게 3개의 숫자를 입력 받는다.")
    void insert3Number() {
        numbers2.clear();
        Scanner sc = TestUtil.getScanner("123");
        String number = sc.nextLine();

        stringToSet(number);

        assertThat(numbers2.size()).isEqualTo(3);
    }

    void stringToSet(String number) {
        for (int i = 0; i < number.length(); i++)
        {
            numbers2.add(number.charAt(i) - '0');
        }
    }

    @Test
    @DisplayName("입력한 숫자와 임의의 숫자를 비교한다.")
    void getResult() {
        String result = Result.getResult(numbers, numbers2);
        assertThat(result).isEqualTo("1스트라이크 2볼");
    }
}