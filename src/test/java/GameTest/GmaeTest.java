package GameTest;

import java.util.ArrayList;
import java.util.List;
import Game.Game;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class GmaeTest {
    @Test
    void checkValidityTest(){
        Game game = new Game();

        List<Integer> numbers= new ArrayList<Integer>();
        assertThat(game.checkValidity(numbers)).isEqualTo(false);

        addValidNumbers(numbers);
        assertThat(game.checkValidity(numbers)).isEqualTo(true);

        addDuplicateNumbers(numbers);
        assertThat(game.checkValidity(numbers)).isEqualTo(false);

        addNumbersWithZero(numbers);
        assertThat(game.checkValidity(numbers)).isEqualTo(false);
    }

    void addValidNumbers(List<Integer> numbers){
        numbers.clear();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    void addDuplicateNumbers(List<Integer> numbers){
        numbers.clear();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
    }
    void addNumbersWithZero(List<Integer> numbers){
        numbers.clear();
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
    }
}
