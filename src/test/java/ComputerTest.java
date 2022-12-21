import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {

    @Test
    void makeNumberTest(){
        for(int i = 0; i < 10000; i++) {
            Computer computer = new Computer();
            assertTrue(testValidate(computer.getAnswer()));
        }
    }

    private boolean testValidate(String answer) {
        Set<Character> set = new HashSet<>();
        for (char c : answer.toCharArray()) {
            set.add(c);
        }
        return set.size()==3;
    }


}

