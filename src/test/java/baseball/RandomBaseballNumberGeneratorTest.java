package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class RandomBaseballNumberGeneratorTest {

    @Test
    void generateRandomBaseballNumberTest() {
        RandomBaseballNumberGenerator randomBaseballNumberGenerator = new RandomBaseballNumberGenerator();
        List<Integer> randomBaseballNumber = randomBaseballNumberGenerator.generateRandomBaseballNumber();

        System.out.println(randomBaseballNumber);
        assertThat(randomBaseballNumber).hasSize(3);
        assertThat(randomBaseballNumber).allMatch(num -> num >= 1 && num <= 9);
        assertThat(randomBaseballNumber).doesNotHaveDuplicates();
    }
}