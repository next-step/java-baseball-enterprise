package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PlayerTest {

    @ParameterizedTest
    @MethodSource
    void checkValidSize_throwException(List<Integer> numbers) {
        assertThatThrownBy(() -> Player.checkValidSize(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> checkValidSize_throwException() {
        return Stream.of(
                arguments(List.of()),
                arguments(List.of(1)),
                arguments(List.of(1, 2)),
                arguments(List.of(1, 2, 3, 4)),
                arguments(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest
    @MethodSource
    void checkValidSize_success(List<Integer> numbers) {
        assertThatNoException()
                .isThrownBy(() -> Player.checkValidSize(numbers));
    }

    private static Stream<Arguments> checkValidSize_success() {
        return Stream.of(
                arguments(List.of(1, 2, 3)),
                arguments(List.of(6, 4, 2)),
                arguments(List.of(1, 1, 9))
        );
    }

    @ParameterizedTest
    @MethodSource
    void checkDuplicate_throwException(List<Integer> numbers) {
        assertThatThrownBy(() -> Player.checkDuplicate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> checkDuplicate_throwException() {
        return Stream.of(
                arguments(List.of(1, 1, 2)),
                arguments(List.of(6, 4, 6)),
                arguments(List.of(0, 0, 0)),
                arguments(List.of(0, 9, 9))
        );
    }

    @ParameterizedTest
    @MethodSource
    void checkDuplicate_success(List<Integer> numbers) {
        assertThatNoException()
                .isThrownBy(() -> Player.checkDuplicate(numbers));
    }

    private static Stream<Arguments> checkDuplicate_success() {
        return Stream.of(
                arguments(List.of(1, 2, 3)),
                arguments(List.of(6, 4, 2)),
                arguments(List.of(9, 8, 7))
        );
    }

    @ParameterizedTest
    @MethodSource
    void checkValidRange_throwException(List<Integer> numbers) {
        assertThatThrownBy(() -> Player.checkValidRange(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> checkValidRange_throwException() {
        return Stream.of(
                arguments(List.of(0, 2, 3)),
                arguments(List.of(6, -1, 2)),
                arguments(List.of(1, 1, 10)),
                arguments(List.of(10, 10, 10))
        );
    }

    @ParameterizedTest
    @MethodSource
    void checkValidRange_success(List<Integer> numbers) {
        assertThatNoException()
                .isThrownBy(() -> Player.checkValidRange(numbers));
    }

    private static Stream<Arguments> checkValidRange_success() {
        return Stream.of(
                arguments(List.of(1, 2, 3)),
                arguments(List.of(6, 4, 8)),
                arguments(List.of(5, 7, 9))
        );
    }
}