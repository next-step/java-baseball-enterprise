package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    BaseballGame baseballGame = new BaseballGameImpl();

    @Test
    @DisplayName("baseball_game_play")
    void baseballGamePlayTest(){
        baseballGame.play(1);
    }

}