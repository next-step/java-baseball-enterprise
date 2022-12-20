package com.neurumaru.baseball;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballDataTest {
    @Test
    void getDefaultLanguageDataMap() {
        Map<String, String> languageDataMap = BaseballData.getDefaultLanguageDataMap();
        assertThat(languageDataMap.get(BaseballData.REQUEST_INPUT_NUMBER_TAG))
                .isEqualTo(BaseballData.REQUEST_INPUT_NUMBER_DEFAULT);
        assertThat(languageDataMap.get(BaseballData.STRIKE_TAG)).isEqualTo((BaseballData.STRIKE_DEFAULT));
        assertThat(languageDataMap.get(BaseballData.BALL_TAG)).isEqualTo((BaseballData.BALL_DEFAULT));
        assertThat(languageDataMap.get(BaseballData.NOTHING_TAG)).isEqualTo((BaseballData.NOTHING_DEFAULT));
        assertThat(languageDataMap.get(BaseballData.GAME_TERMINATION_TAG))
                .isEqualTo((BaseballData.GAME_TERMINATION_DEFAULT));
        assertThat(languageDataMap.get(BaseballData.RESTART_TAG)).isEqualTo((BaseballData.RESTART_DEFAULT));
    }

    @Test
    void getLanguageDataMapTest() {
        Map<String, String> languageData = BaseballData.getLanguageDataMap("Korean.xml");
        assertThat(languageData.containsKey(BaseballData.REQUEST_INPUT_NUMBER_TAG)).isTrue();
        assertThat(languageData.containsKey(BaseballData.STRIKE_TAG)).isTrue();
        assertThat(languageData.containsKey(BaseballData.BALL_TAG)).isTrue();
        assertThat(languageData.containsKey(BaseballData.NOTHING_TAG)).isTrue();
        assertThat(languageData.containsKey(BaseballData.GAME_TERMINATION_TAG)).isTrue();
        assertThat(languageData.containsKey(BaseballData.RESTART_TAG)).isTrue();
    }

    @Test
    void getStrikeMapTest() {
        Map<String, String> strikeMap = BaseballData.getStrikeMap(1);
        assertThat(strikeMap.get("{0}")).isEqualTo("1");
    }

    @Test
    void getBallMapTest() {
        Map<String, String> ballMap = BaseballData.getBallMap(2);
        assertThat(ballMap.get("{0}")).isEqualTo("2");
    }

    @Test
    void getGameTerminationMapTest() {
        Map<String, String> gameTerminationMap = BaseballData.getGameTerminationMap(3);
        assertThat(gameTerminationMap.get("{0}")).isEqualTo("3");
    }

    @Test
    void getRestartMapTest() {
        Map<String, String> restartMap = BaseballData.getRestartMap(1, 2);
        assertThat(restartMap.get("{0}")).isEqualTo("1");
        assertThat(restartMap.get("{1}")).isEqualTo("2");
    }
}
