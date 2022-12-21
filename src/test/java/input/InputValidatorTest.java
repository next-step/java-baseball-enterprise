package input;

import exception.InputLengthValidationException;
import exception.InputNumberDuplicationException;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @MethodSource("prepareInputOfInvalidSize")
    void validateInput_입력_길이가_올바르지_않으면_예외_발생(List<Integer> input) {
        assertThatExceptionOfType(InputLengthValidationException.class)
                .isThrownBy(() -> inputValidator.validateInput(input))
                .withMessage(InputLengthValidationException.INPUT_LENGTH_VALIDATION_EXCEPTION_MESSAGE);
    }

    Stream<Arguments> prepareInputOfInvalidSize() {
        return Stream.of(
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1, 2, 3, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("prepareInputOfValidSize")
    void validateInput_입력_길이가_올바르면_정상_실행(List<Integer> input) {
        assertDoesNotThrow(() -> inputValidator.validateInput(input));
    }

    Stream<Arguments> prepareInputOfValidSize() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(2, 3, 4)),
                Arguments.of(List.of(4, 5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("prepareInputHavingDuplicatedNumbers")
    void validateInput_입력에_중복된_숫자가_존재하면_예외_발생(List<Integer> input) {
        assertThatExceptionOfType(InputNumberDuplicationException.class)
                .isThrownBy(() -> inputValidator.validateInput(input))
                .withMessage(InputNumberDuplicationException.INPUT_NUMBER_DUPLICATION_EXCEPTION_MESSAGE);
    }

    Stream<Arguments> prepareInputHavingDuplicatedNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 1)),
                Arguments.of(List.of(1, 1, 2)),
                Arguments.of(List.of(1, 4, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("prepareInputNotHavingDuplicatedNumbers")
    void validateInput_입력에_중복된_숫자가_없으면_정상_실행(List<Integer> input) {
        assertDoesNotThrow(() -> inputValidator.validateInput(input));
    }

    Stream<Arguments> prepareInputNotHavingDuplicatedNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(1, 4, 5)),
                Arguments.of(List.of(2, 3, 4))
        );
    }
}
