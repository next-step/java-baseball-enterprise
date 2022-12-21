package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class ComputerSimulatorTest {

    @Test
    public void calculateBallcountStrikeTest() {
        List<Integer> answer = List.of(1, 2, 3);
        ComputerSimulator simulator = new ComputerSimulator();
        simulator.setAnswer(answer);

        Ballcount ballcount = simulator.calculateBallcount(List.of(9, 2, 3));

        assertThat(ballcount.getStrikes()).isEqualTo(2);
        assertThat(ballcount.getBalls()).isEqualTo(0);
    }

    @Test
    public void calculateBallcountBallTest() {
        List<Integer> answer = List.of(1, 2, 3);
        ComputerSimulator simulator = new ComputerSimulator();
        simulator.setAnswer(answer);

        Ballcount ballcount = simulator.calculateBallcount(List.of(2, 3, 1));

        assertThat(ballcount.getStrikes()).isEqualTo(0);
        assertThat(ballcount.getBalls()).isEqualTo(3);
    }
}
