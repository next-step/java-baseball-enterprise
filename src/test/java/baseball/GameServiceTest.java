package baseball;

import baseball.domain.Computer;
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

import static baseball.GameService.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameServiceTest {

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

    @Test
    void constValueTest() {
        assertThat(NUMBERS_SIZE)
                .isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(9);
        assertThat(MAX_NUMBER).isGreaterThanOrEqualTo(MIN_NUMBER);
        assertThat(MAX_NUMBER).isLessThan(10);
        assertThat(MIN_NUMBER).isGreaterThan(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "542", "163", "987", "519"})
    void inputPlayer_systemIn(String input) {
        // given
        GameService gameService = new GameService();
        setUpSystemInput(input);
        GameService.scanner = new Scanner(System.in);
        // when
        Player result = gameService.inputPlayer();
        // then
        List<Integer> expected = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        assertThat(result.getNumbers()).containsExactlyElementsOf(expected);
    }

    @Test
    void inputPlayer_systemOut() {
        // given
        GameService gameService = new GameService();
        setUpSystemInput("123");
        GameService.scanner = new Scanner(System.in);
        // when
        gameService.inputPlayer();
        // then
        assertThat(output.toString()).isEqualTo("숫자를 입력해주세요 : ");
    }

    @Test
    void playWithContinue() {
        // given
        Computer testComputer = Computer.of(List.of(1, 2, 3));
        GameService gameService = new GameService();
        setUpSystemInput("124\n567\n123");
        GameService.scanner = new Scanner(System.in);
        // when
        gameService.play(testComputer);
        // then
        assertThat(output.toString()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @ParameterizedTest
    @MethodSource
    void wantRetry_systemIn_success(String playerInput, boolean expected) {
        setUpSystemInput(playerInput);
        GameService.scanner = new Scanner(System.in);
        assertThat(GameService.wantRetry()).isEqualTo(expected);
    }

    private static Stream<Arguments> wantRetry_systemIn_success() {
        return Stream.of(
                arguments("1", true),
                arguments("2", false)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "Yes", "N", "Y", "MINION"})
    void wantRetry_systemIn_throwException(String playerInput) {
        setUpSystemInput(playerInput);
        GameService.scanner = new Scanner(System.in);
        assertThatThrownBy(GameService::wantRetry)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void wantRetry_systemOut() {
        setUpSystemInput("1");
        GameService.scanner = new Scanner(System.in);
        GameService.wantRetry();
        assertThat(output.toString()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void setUpSystemInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}