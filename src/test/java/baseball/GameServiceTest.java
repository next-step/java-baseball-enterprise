package baseball;

import baseball.domain.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static baseball.GameService.*;
import static org.assertj.core.api.Assertions.assertThat;

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
        gameService.scanner = new Scanner(System.in);
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
        gameService.scanner = new Scanner(System.in);
        // when
        gameService.inputPlayer();
        // then
        assertThat(output.toString()).isEqualTo("숫자를 입력해주세요 : ");
    }

    private void setUpSystemInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}