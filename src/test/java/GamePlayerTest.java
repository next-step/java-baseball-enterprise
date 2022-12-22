import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class GamePlayerTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final GamePlayer gamePlayer;

    public GamePlayerTest() {
        this.gamePlayer = new GamePlayer(3);
    }

    @Test
    @DisplayName("정답 여부가 맞게 결정되는가?")
    void test1() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        // private 메서드 접근 허용
        Method testMethod = GamePlayer.class.getDeclaredMethod("compareInputWithAnswer");
        Field answerField = GamePlayer.class.getDeclaredField("answer");
        Field userInputField = GamePlayer.class.getDeclaredField("userInput");
        testMethod.setAccessible(true);
        answerField.setAccessible(true);
        userInputField.setAccessible(true);

        answerField.set(gamePlayer, "123");
        userInputField.set(gamePlayer, "321");

        boolean actual = (boolean) testMethod.invoke(gamePlayer);

        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("힌트가 맞게 출력되는가?")
    void test2() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        // private 메서드 접근 허용
        Method testMethod = GamePlayer.class.getDeclaredMethod("compareInputWithAnswer");
        Field answerField = GamePlayer.class.getDeclaredField("answer");
        Field userInputField = GamePlayer.class.getDeclaredField("userInput");
        testMethod.setAccessible(true);
        answerField.setAccessible(true);
        userInputField.setAccessible(true);

        System.setOut(new PrintStream(out));

        answerField.set(gamePlayer, "123");
        userInputField.set(gamePlayer, "321");

        testMethod.invoke(gamePlayer);

        assertThat(out.toString().strip()).isEqualTo("1스트라이크 2볼");
    }

    @Test
    @DisplayName("일치하는 수가 없는 경우 '낫싱'이 출력되는가?")
    void test3() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        // private 메서드 접근 허용
        Method testMethod = GamePlayer.class.getDeclaredMethod("compareInputWithAnswer");
        Field answerField = GamePlayer.class.getDeclaredField("answer");
        Field userInputField = GamePlayer.class.getDeclaredField("userInput");
        testMethod.setAccessible(true);
        answerField.setAccessible(true);
        userInputField.setAccessible(true);

        System.setOut(new PrintStream(out));

        answerField.set(gamePlayer, "123");
        userInputField.set(gamePlayer, "456");

        testMethod.invoke(gamePlayer);

        assertThat(out.toString().strip()).isEqualTo("낫싱");
    }
}