package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ComputerTest {

    @ParameterizedTest
    @MethodSource
    void generateRandomUniqueNumbers_validValues(int startInclude, int endInclude, int size) {
        List<Integer> result = Computer.generateRandomUniqueNumbers(startInclude, endInclude, size);

        assertThat(result).hasSize(size);
        assertThat(result).doesNotHaveDuplicates();
        assertEachElementValidRange(startInclude, endInclude, result);
    }

    private static void assertEachElementValidRange(int startInclude, int endInclude, List<Integer> result) {
        for (Integer number : result) {
            assertThat(number)
                    .isGreaterThanOrEqualTo(startInclude)
                    .isLessThanOrEqualTo(endInclude);
        }
    }

    private static Stream<Arguments> generateRandomUniqueNumbers_validValues() {
        return Stream.of(
                arguments(1, 5, 3),
                arguments(4, 5, 2),
                arguments(0, 10, 4),
                arguments(2, 6, 3),
                arguments(4, 4, 1)
        );
    }

    @ParameterizedTest
    @MethodSource
    void generateRandomUniqueNumbers_invalidValues(int startInclude, int endInclude, int size) {
        assertThatThrownBy(() -> Computer.generateRandomUniqueNumbers(startInclude, endInclude, size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> generateRandomUniqueNumbers_invalidValues() {
        return Stream.of(
                arguments(1, 5, -1),
                arguments(5, 3, 1),
                arguments(0, -2, 2),
                arguments(2, 6, 6),
                arguments(4, 4, 2)
        );
    }

}