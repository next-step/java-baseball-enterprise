package service;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomGeneratorTest {

    @Test
    void generateRandomNumber_sizeIsThree() {
        List<Integer> randomNumber = RandomGenerator.generateRandomNumber();
        assertThat(randomNumber.size()).isEqualTo(3);
    }

    @Test
    void generateRandomNumber_noDuplicate() {
        List<Integer> randomNumber = RandomGenerator.generateRandomNumber();
        assertThat(new HashSet<>(randomNumber).size()).isEqualTo(randomNumber.size());
    }

    @Test
    void generateRandomNumber_isInRange() {
        List<Integer> randomNumber = RandomGenerator.generateRandomNumber();
        for (Integer num : randomNumber) {
            assertThat(num).isBetween(1, 9);
        }
    }
}