package baseball.model;

import baseball.controller.request.BaseballNumberRequest;
import baseball.controller.request.RestartRequest;
import baseball.controller.response.GameResponse;
import baseball.model.domain.BaseballNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class GameTest {

    @DisplayName("BaseballNumber를 주입시켜 실행중인 Game을 생성할 수 있다.")
    @Test
    void create() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(1,2,3);

        // when
        Game game = new Game(baseballNumber);

        // then
        assertThat(game.isPlaying()).isTrue();
    }

    @DisplayName("BaseballNumberRequest를 통해 현재 요청이 몇 스트라이크 몇 볼인지 확인할 수 있다.")
    @Test
    void compare() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(1,2,3);
        Game game = new Game(baseballNumber);
        BaseballNumberRequest baseballNumberRequest = new BaseballNumberRequest(1, 2, 4);

        // when
        GameResponse gameResponse = game.compare(baseballNumberRequest);

        // then
        assertThat(gameResponse.getStrike()).isEqualTo(2);
        assertThat(gameResponse.getBall()).isEqualTo(0);
        assertThat(gameResponse.isPlaying()).isTrue();
    }

    @DisplayName("BaseballNumberRequest를 통해 현재 요청이 3 스트라이크라면 게임이 종료된다.")
    @Test
    void compareThreeStrike() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(1,2,3);
        Game game = new Game(baseballNumber);
        BaseballNumberRequest baseballNumberRequest = new BaseballNumberRequest(1, 2, 3);

        // when
        GameResponse gameResponse = game.compare(baseballNumberRequest);

        // then
        assertThat(gameResponse.getStrike()).isEqualTo(3);
        assertThat(gameResponse.getBall()).isEqualTo(0);
        assertThat(gameResponse.isPlaying()).isFalse();
    }

    @DisplayName("끝난 게임에 대해서는 Restart 할 수 있다.")
    @Test
    void restart() {
        // given
        Game game = endedGame();
        RestartRequest restartRequest = new RestartRequest(true);

        // when
        game.restart(restartRequest);

        // then
        assertThat(game.isPlaying()).isTrue();
    }

    private static Game endedGame() {
        BaseballNumber baseballNumber = new BaseballNumber(1,2,3);
        Game game = new Game(baseballNumber);
        BaseballNumberRequest baseballNumberRequest = new BaseballNumberRequest(1, 2, 3);
        game.compare(baseballNumberRequest);
        return game;
    }

    @DisplayName("끝난 게임에 대해 Restart 옵션이 false 라면 재시작하지 않는다.")
    @Test
    void restartFalse() {
        // given
        Game game = endedGame();
        RestartRequest restartRequest = new RestartRequest(false);

        // when
        game.restart(restartRequest);

        // then
        assertThat(game.isPlaying()).isFalse();
    }

    @DisplayName("끝난 게임이 아니라면 재시작할 수 없다.")
    @Test
    void restartUnavailable() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(1,2,3);
        Game game = new Game(baseballNumber);
        RestartRequest restartRequest = new RestartRequest(true);

        // when & then
        assertThatThrownBy(() -> game.restart(restartRequest))
                .isInstanceOf(IllegalArgumentException.class);
    }
}