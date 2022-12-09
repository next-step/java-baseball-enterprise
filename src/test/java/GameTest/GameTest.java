package GameTest;

import java.util.ArrayList;
import java.util.List;
import Game.Game;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class GameTest {
    @Test
    void checkValidityTest(){
        Game game = new Game();

        List<Integer> numbers= new ArrayList<Integer>();
        assertThat(game.checkValidity(numbers)).isEqualTo(false);

        setValidNumbers(numbers);
        assertThat(game.checkValidity(numbers)).isEqualTo(true);

        setDuplicateNumbers(numbers);
        assertThat(game.checkValidity(numbers)).isEqualTo(false);

        setNumbersWithZero(numbers);
        assertThat(game.checkValidity(numbers)).isEqualTo(false);
    }

    void setValidNumbers(List<Integer> numbers){
        numbers.clear();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    void setDuplicateNumbers(List<Integer> numbers){
        numbers.clear();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
    }
    void setNumbersWithZero(List<Integer> numbers){
        numbers.clear();
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
    }
}
