package baseball.view;

import baseball.GameService;
import baseball.domain.GameResult;
import baseball.domain.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameViewTest {


    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "542", "163", "987", "519"})
    void inputPlayer_systemIn(String input) {
        // given
        GameService gameService = new GameService();
        setUpSystemInput(input);
        GameView.scanner = new Scanner(System.in);
        // when
        Player result = GameView.inputPlayer();
        // then
        List<Integer> expected = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        assertThat(result.getNumbers()).containsExactlyElementsOf(expected);
    }

    @Test
    void inputPlayer_systemOut() {
        // given
        setUpSystemInput("123");
        GameView.scanner = new Scanner(System.in);
        // when
        GameView.inputPlayer();
        // then
        assertThat(output.toString()).isEqualTo("숫자를 입력해주세요 : ");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "Yes", "N", "Y", "MINION"})
    void wantRetry_systemIn_throwException(String playerInput) {
        setUpSystemInput(playerInput);
        GameView.scanner = new Scanner(System.in);
        assertThatThrownBy(GameService::wantRetry)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void wantRetry_systemOut() {
        setUpSystemInput("1");
        GameView.scanner = new Scanner(System.in);
        GameView.getRetryCommand();
        assertThat(output.toString()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @ParameterizedTest
    @MethodSource
    void wantRetry_systemIn_success(String playerInput, int expected) {
        setUpSystemInput(playerInput);
        GameView.scanner = new Scanner(System.in);
        assertThat(GameView.getRetryCommand()).isEqualTo(expected);
    }

    private static Stream<Arguments> wantRetry_systemIn_success() {
        return Stream.of(
                arguments("1", 1),
                arguments("2", 2)
        );
    }

    @ParameterizedTest
    @MethodSource
    void print(List<Integer> player, List<Integer> computer, String expectedResult) {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        GameView.printResult(GameResult.getResult(player, computer));

        assertThat(output.toString()).contains(expectedResult);
    }

    private static Stream<Arguments> print() {
        return Stream.of(
                arguments(List.of(1, 2, 3), List.of(4, 5, 6), "낫싱"),
                arguments(List.of(1, 2, 3), List.of(4, 3, 5), "1볼"),
                arguments(List.of(1, 2, 3), List.of(4, 5, 3), "1스트라이크"),
                arguments(List.of(1, 2, 3), List.of(4, 2, 1), "1스트라이크 1볼"),
                arguments(List.of(1, 2, 3), List.of(1, 3, 2), "1스트라이크 2볼"),
                arguments(List.of(1, 2, 3), List.of(1, 2, 3), "3스트라이크")
        );
    }

    private void setUpSystemInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}