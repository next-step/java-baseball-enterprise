package Computer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class ComputerTest {
    @Test
    void initiateNumberTest(){
        Computer computer = new Computer();

        assertThat(computer.setNumber()).isEqualTo(3);
    }
}
