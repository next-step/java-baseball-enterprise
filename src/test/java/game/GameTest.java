package game;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    Game game = new Game();

    @Test
    void testRandomNumberSizeIs3() throws Exception {
        Method method = Game.class.getDeclaredMethod("makeRandomNumber");
        method.setAccessible(true);
        Field field = Game.class.getDeclaredField("answer");
        field.setAccessible(true);

        ArrayList<Integer> array = (ArrayList<Integer>)field.get(game);
        method.invoke(game);
        assertThat(array.size()).isEqualTo(3);
    }

    @Test
    void testRandomNumberIsNotDuplicated() throws Exception {
        Method method = Game.class.getDeclaredMethod("makeRandomNumber");
        method.setAccessible(true);
        Field field = Game.class.getDeclaredField("answer");
        field.setAccessible(true);

        ArrayList<Integer> array = (ArrayList<Integer>)field.get(game);
        method.invoke(game);

        Set<Integer> set = new HashSet<>(array);
        assertThat(set.size()).isEqualTo(array.size());
    }
}
