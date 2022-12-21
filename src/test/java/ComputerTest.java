import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    private static Computer computer;

    @BeforeAll
    static void initAll() {
        computer = new Computer();
    }

    @Test
    @DisplayName("랜덤넘버가 중복되지 않는지 확인")
    void testRandomNumberUnique() {
        Integer[] randomNumbers = computer.getThreeUniqueRandomNumbers();
        assertThat(randomNumbers[0]).isNotEqualTo(randomNumbers[1]);
        assertThat(randomNumbers[0]).isNotEqualTo(randomNumbers[2]);
        assertThat(randomNumbers[1]).isNotEqualTo(randomNumbers[2]);
    }

    @Test
    @DisplayName("랜덤넘버가 1-9 사이인지 확인")
    void testRandomNumberInBoundary() {
        Integer[] randomNumbers = computer.getThreeUniqueRandomNumbers();
        for (Integer number : randomNumbers) {
            assertThat(number).isBetween(1, 9);
        }
    }

    @Test
    @DisplayName("점수 계산 테스트: 1스트라이크")
    void testCalculateScoresOneStrike() {
        Integer[] computerNumbers = {4, 2, 5};
        computer.setNumbers(computerNumbers);

        Integer[] playerNumbersCaseOne = {1, 2, 3};
        assertThat(computer.calculateScores(playerNumbersCaseOne)).containsExactly(1, 0);
    }
    @Test
    @DisplayName("점수 계산 테스트: 1스트라이크 1볼")
    void testCalculateScoresOneStrikeOneBall() {
        Integer[] computerNumbers = {4, 2, 5};
        computer.setNumbers(computerNumbers);

        Integer[] playerNumbersCaseTwo = {4, 5, 6};
        assertThat(computer.calculateScores(playerNumbersCaseTwo)).containsExactly(1, 1);
    }
    @Test
    @DisplayName("점수 계산 테스트: 낫싱")
    void testCalculateScores1Strike() {
        Integer[] computerNumbers = {4, 2, 5};
        computer.setNumbers(computerNumbers);

        Integer[] playerNumbersCaseThree = {7, 8, 9};
        assertThat(computer.calculateScores(playerNumbersCaseThree)).containsExactly(0, 0);
    }
}
