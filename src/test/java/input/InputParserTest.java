package input;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InputParserTest {

    InputParser inputParser = new InputParser();

    @ParameterizedTest
    @ValueSource(strings = {"a123", "abc", "12a34"})
    void toIntegerList_숫자가_아닌_입력시_예외_발생(String input) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> inputParser.toIntegerList(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "1234", "1231241"})
    void toIntegerList_숫자만_있는_입력시_정상_실행(String input) {
        assertDoesNotThrow(() -> inputParser.toIntegerList(input));
    }
}
