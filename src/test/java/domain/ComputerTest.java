package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @DisplayName("1 ~ 9 사이의 임의의 수 생성 테스트")
    @Test
    void generateRandomNumberTest() {
        Computer computer = new Computer();
        int min = 1, max = 9;

        for (int i = 0; i < 100; i++) {
            int randomNumber = computer.generateRandomNumber();
            assertThat(randomNumber).isGreaterThanOrEqualTo(min).isLessThanOrEqualTo(max);
        }
    }

    @DisplayName("서로 다른 임의의 수 3개 생성 테스트")
    @Test
    void generateThreeDifferentNumberTest() {
        Computer computer = new Computer();
        char[] nums = computer.generateThreeDifferentNumber()
                .toCharArray();

        assertThat(nums[0]).isNotEqualTo(nums[1]);
        assertThat(nums[0]).isNotEqualTo(nums[2]);
        assertThat(nums[1]).isNotEqualTo(nums[2]);
    }

}