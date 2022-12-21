package domain;



import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    @Test
    void create(){
        Computer computer = new Computer(new ArrayList<>(Arrays.asList(7, 1, 3)));
        String actual = computer.getNumbers().toString();
        assertThat(actual).isEqualTo("[7, 1, 3]");
    }
}
