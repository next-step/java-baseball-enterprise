package study.baseball.engine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @ValueSource(strings = {"777", "112", "911", "707"})
    public void testParseDuplicatedInput(String input) {
        assertThatThrownBy(() -> {
            List<Integer> numbers = parser.parseStringToIntegerList(input);
        }).isInstanceOf(RuntimeException.class).hasMessage("중복된 숫자가 존재합니다.");
    }
}