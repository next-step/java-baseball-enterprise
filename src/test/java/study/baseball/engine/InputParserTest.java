package study.baseball.engine;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputParserTest {
    private final InputParser parser = new InputParser();

    @ParameterizedTest
    @ValueSource(strings = {"123", "076", "234", "543", "932"})
    public void testParseValidInput(String input) {
        List<Integer> numbers = parser.parseStringToIntegerList(input);
        assertThat(numbers).hasSize(3);
    }
}