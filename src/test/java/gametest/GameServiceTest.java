package gametest;

import game.GameService;
import game.ResultEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest {
    private final GameService gameService = new GameService();

    @DisplayName("[GameService] 결과 계산 로직 테스트")
    @ParameterizedTest
    @MethodSource("calcResultTestGenerator")
    void calcResultTest(int[] answer, int[] input, ResultEntity expected) {
        ResultEntity result = gameService.calcResult(answer, input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> calcResultTestGenerator(){
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, new int[]{1,2,3}, new ResultEntity(3, 0)),
                Arguments.of(new int[]{1,2,3}, new int[]{3,1,2}, new ResultEntity(0, 3)),
                Arguments.of(new int[]{1,2,3}, new int[]{4,5,6}, new ResultEntity(0, 0)),
                Arguments.of(new int[]{1,2,3}, new int[]{1,3,2}, new ResultEntity(1, 2)),
                Arguments.of(new int[]{1,2,3}, new int[]{1,2,4}, new ResultEntity(2, 0))
        );
    }


}
