import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgeTest {

    Judge judge;
    int[] result1;
    int[] result2;
    int[] result3;
    int[] result4;

    @BeforeEach
    void setUp() {
        judge = new Judge();
        result1 = judge.getStrikeAndBall(new int[] {4, 2, 5}, Arrays.asList(1, 2, 3));
        result2 = judge.getStrikeAndBall(new int[] {4, 2, 5}, Arrays.asList(4, 5, 6));
        result3 = judge.getStrikeAndBall(new int[] {4, 2, 5}, Arrays.asList(7, 8, 9));
        result4 = judge.getStrikeAndBall(new int[] {4, 2, 5}, Arrays.asList(4, 2, 5));
    }

    @Test
    @DisplayName("판단: 스트라이크 및 볼 개수 테스트")
    void countTest() {
        assertThat(new int[] {1, 0}).isEqualTo(result1);
        assertThat(new int[] {1, 1}).isEqualTo(result2);
        assertThat(new int[] {0, 0}).isEqualTo(result3);
        assertThat(new int[] {3, 0}).isEqualTo(result4);
    }

    @Test
    @DisplayName("판단: 결과 출력 테스트")
    void displayTest() {
        assertThat("1 스트라이크 ").isEqualTo(judge.setOutput(result1));
        assertThat("1 스트라이크 1 볼").isEqualTo(judge.setOutput(result2));
        assertThat("낫싱").isEqualTo(judge.setOutput(result3));
        assertThat("3 스트라이크 ").isEqualTo(judge.setOutput(result4));
    }

}
