package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class BaseballGameTest {
    private final String answer;
    private BaseballGame bg;
    private final int DIGITS = 3;

    public BaseballGameTest() throws NoSuchFieldException, IllegalAccessException {
        bg = new BaseballGame();
        Field answerField = bg.getClass().getDeclaredField("answer");
        answerField.setAccessible(true);
        answer = String.valueOf(answerField.get(bg));
        System.out.println("answer = " + answer);
    }

    @RepeatedTest(100)
    @DisplayName("정답생성: 숫자가 3자리로 이루어져있는가??")
    void numberGenerateTest1() {
        Assertions.assertThat(answer.length()).isEqualTo(DIGITS);
    }

    @RepeatedTest(100)
    @DisplayName("정답생성: 숫자로만 이루어져있는가?")
    void numberGenerateTest2() {
        boolean flag = true;
        for(int i =0; i<DIGITS; i++) {
            if (answer.charAt(i) > '9' || answer.charAt(i) < '0') {
                flag = false;
                break;
            }
        }
        Assertions.assertThat(flag).isTrue();
    }

    @RepeatedTest(100)
    @DisplayName("정답생성: 중복되는 숫자가 없는가?")
    void numberGenerateTest3() {
        Set<Integer> hashSet = new HashSet<Integer>();
        for(int i =0; i<DIGITS; i++) {
            int number = Character.getNumericValue(answer.charAt(i));
            hashSet.add(number);
        }
        Assertions.assertThat(hashSet.size()).isEqualTo(DIGITS);
    }

    @RepeatedTest(100)
    @DisplayName("정답생성: 0이 포함돼있지 않는가?")
    void numberGenerateTest4() {
        Assertions.assertThat(answer.contains("0")).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"01", "dsada", "dw", "fwqf", "\n", " ", "d"})
    @DisplayName("유저입력: 입력이 3자리가 아닐 때")
    void userInputTest1(String input) {
        InputStream in;

        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> {
            bg.getUserInput();
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("입력이 3자리가 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"12a", "aaa", "13a", "a21"})
    @DisplayName("유저입력: 입력이 숫자로 구성돼있지 않을 때")
    void userInputTest2(String input) {
        InputStream in;

        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> {
            bg.getUserInput();
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("입력이 숫자로 구성돼있지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"121", "333", "133", "225"})
    @DisplayName("유저입력: 중복된 숫자가 입력됐을 때")
    void userInputTest3(String input) {
        InputStream in;

        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> {
            bg.getUserInput();
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("중복된 숫자가 입력됐습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "532", "198", "236"})
    @DisplayName("유저입력: 정상적인 숫자가 입력됐을 때")
    void userInputTest4(String input) {
        InputStream in;

        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatNoException().isThrownBy(() -> {
            bg.getUserInput();
        });
    }


    void setAnswer(String s) throws NoSuchFieldException, IllegalAccessException {
        Field answerField = bg.getClass().getDeclaredField("answer");
        answerField.setAccessible(true);
        answerField.set(bg, s);
    }
    @ParameterizedTest
    @DisplayName("input 판정: 3strike")
    @MethodSource("provideStringsFor3Strike")
    void resultSetTest(String aw, String tg) throws NoSuchFieldException, IllegalAccessException {
        setAnswer(aw);
        InputStream in;
        in = new ByteArrayInputStream(tg.getBytes());
        System.setIn(in);
        GameResultSet rs = bg.proceedRound();
        Assertions.assertThat(rs).isEqualTo(new GameResultSet(3, 0));
    }

    private static Stream<Arguments> provideStringsFor3Strike() {
        return Stream.of(
                Arguments.of("123", "123"),
                Arguments.of("475", "475"),
                Arguments.of("432", "432"),
                Arguments.of("215", "215")
        );
    }

    @ParameterizedTest
    @DisplayName("input 판정: 2strike")
    @MethodSource("provideStringsFor2Strike")
    void resultSetTest2(String aw, String tg) throws NoSuchFieldException, IllegalAccessException {
        setAnswer(aw);
        InputStream in;
        in = new ByteArrayInputStream(tg.getBytes());
        System.setIn(in);
        GameResultSet rs = bg.proceedRound();
        Assertions.assertThat(rs).isEqualTo(new GameResultSet(2, 0));
    }

    private static Stream<Arguments> provideStringsFor2Strike() {
        return Stream.of(
                Arguments.of("123", "124"),
                Arguments.of("475", "375"),
                Arguments.of("432", "482"),
                Arguments.of("215", "216")
        );
    }

    @ParameterizedTest
    @DisplayName("input 판정: 1strike 2Ball")
    @MethodSource("provideStringsFor1Strike2Ball")
    void resultSetTest3(String aw, String tg) throws NoSuchFieldException, IllegalAccessException {
        setAnswer(aw);
        InputStream in;
        in = new ByteArrayInputStream(tg.getBytes());
        System.setIn(in);
        GameResultSet rs = bg.proceedRound();
        Assertions.assertThat(rs).isEqualTo(new GameResultSet(1, 2));
    }

    private static Stream<Arguments> provideStringsFor1Strike2Ball() {
        return Stream.of(
                Arguments.of("123", "132"),
                Arguments.of("475", "745"),
                Arguments.of("432", "234"),
                Arguments.of("215", "512")
        );
    }

    @ParameterizedTest
    @DisplayName("input 판정: 3Ball")
    @MethodSource("provideStringsFor3Ball")
    void resultSetTest4(String aw, String tg) throws NoSuchFieldException, IllegalAccessException {
        setAnswer(aw);
        InputStream in;
        in = new ByteArrayInputStream(tg.getBytes());
        System.setIn(in);
        GameResultSet rs = bg.proceedRound();
        Assertions.assertThat(rs).isEqualTo(new GameResultSet(0, 3));
    }

    private static Stream<Arguments> provideStringsFor3Ball() {
        return Stream.of(
                Arguments.of("123", "312"),
                Arguments.of("475", "754"),
                Arguments.of("432", "324"),
                Arguments.of("215", "521")
        );
    }

    @ParameterizedTest
    @DisplayName("input 판정: 1Ball")
    @MethodSource("provideStringsFor1Ball")
    void resultSetTest5(String aw, String tg) throws NoSuchFieldException, IllegalAccessException {
        setAnswer(aw);
        InputStream in;
        in = new ByteArrayInputStream(tg.getBytes());
        System.setIn(in);
        GameResultSet rs = bg.proceedRound();
        Assertions.assertThat(rs).isEqualTo(new GameResultSet(0, 1));
    }

    private static Stream<Arguments> provideStringsFor1Ball() {
        return Stream.of(
                Arguments.of("123", "451"),
                Arguments.of("475", "723"),
                Arguments.of("432", "526"),
                Arguments.of("215", "539")
        );
    }
    @ParameterizedTest
    @DisplayName("input 판정: Nothing")
    @MethodSource("provideStringsForNothing")
    void resultSetTest6(String aw, String tg) throws NoSuchFieldException, IllegalAccessException {
        setAnswer(aw);
        InputStream in;
        in = new ByteArrayInputStream(tg.getBytes());
        System.setIn(in);
        GameResultSet rs = bg.proceedRound();
        Assertions.assertThat(rs).isEqualTo(new GameResultSet(0, 0));
    }

    private static Stream<Arguments> provideStringsForNothing() {
        return Stream.of(
                Arguments.of("123", "456"),
                Arguments.of("475", "362"),
                Arguments.of("432", "569"),
                Arguments.of("215", "698")
        );
    }

//    @Test
//    @DisplayName("게임 전체 테스트")
//    void testGame() {
//        bg.play();
//    }
}
