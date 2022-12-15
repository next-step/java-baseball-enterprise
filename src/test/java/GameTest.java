import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private final Game game = new Game();

    @Test
    void countTest(){
        String answer = "456";
        HashMap<Character, Integer> computer = new HashMap<>();
        Common.setPositionNumber(answer, computer);

        String[] input = {
                "123", "234", "456", "567", "678", "789"
        };
        for(int i = 0; i < input.length; i++) {
            HashMap<Character, Integer> human = new HashMap<>();

            Common.setPositionNumber(input[i], human);
            if(!input[i].equals(answer))
                assertFalse(game.count(computer, human));
            else
                assertTrue(game.count(computer, human));
        }
    }
}

