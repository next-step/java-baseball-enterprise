package score;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static score.BaseBallJudgement.*;

class BaseBallJudgementTest {

    static Stream<Arguments> prepareStrikeTrueData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 1, 0),
                Arguments.of(List.of(1, 2, 3), 2, 1),
                Arguments.of(List.of(1, 2, 3), 3, 2)
        );
    }

    static Stream<Arguments> prepareStrikeFalseData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 2, 0),
                Arguments.of(List.of(1, 2, 3), 2, 2),
                Arguments.of(List.of(1, 2, 3), 3, 1)
        );
    }

    static Stream<Arguments> prepareBallTrueData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 2, 0),
                Arguments.of(List.of(1, 2, 3), 2, 2),
                Arguments.of(List.of(1, 2, 3), 3, 1)
        );
    }

    static Stream<Arguments> prepareBallFalseData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 2, 1),
                Arguments.of(List.of(1, 2, 3), 4, 2),
                Arguments.of(List.of(1, 2, 3), 5, 1)
        );
    }

    static Stream<Arguments> prepareNothingTrueData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 4, 0),
                Arguments.of(List.of(1, 2, 3), 5, 2),
                Arguments.of(List.of(1, 2, 3), 6, 1)
        );
    }

    static Stream<Arguments> prepareNothingFalseData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 2, 0),
                Arguments.of(List.of(1, 2, 3), 2, 2),
                Arguments.of(List.of(1, 2, 3), 3, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("prepareStrikeTrueData")
    void STRIKE_같은_위치에_같은_숫자가_있으면_스트라이크_true(List<Integer> answer, Integer userNum, Integer pos) {
        assertTrue(STRIKE.hit(answer, userNum, pos));
    }

    @ParameterizedTest
    @MethodSource("prepareStrikeFalseData")
    void STRIKE_같은_위치에_같은_숫자가_있으면_스트라이크_false(List<Integer> answer, Integer userNum, Integer pos) {
        assertFalse(STRIKE.hit(answer, userNum, pos));
    }

    @ParameterizedTest
    @MethodSource("prepareBallTrueData")
    void BALL_다른_위치에_같은_숫자가_있으면_볼_true(List<Integer> answer, Integer userNum, Integer pos) {
        assertTrue(BALL.hit(answer, userNum, pos));
    }

    @ParameterizedTest
    @MethodSource("prepareBallFalseData")
    void BALL_다른_위치에_같은_숫자가_있으면_볼_false(List<Integer> answer, Integer userNum, Integer pos) {
        assertFalse(BALL.hit(answer, userNum, pos));
    }

    @ParameterizedTest
    @MethodSource("prepareNothingTrueData")
    void NOTHING_입력한_숫자가_존재하지_않으면_낫싱_true(List<Integer> answer, Integer userNum, Integer pos) {
        assertTrue(NOTHING.hit(answer, userNum, pos));
    }

    @ParameterizedTest
    @MethodSource("prepareNothingFalseData")
    void NOTHING_입력한_숫자가_존재하지_않으면_낫싱_false(List<Integer> answer, Integer userNum, Integer pos) {
        assertFalse(NOTHING.hit(answer, userNum, pos));
    }
}
