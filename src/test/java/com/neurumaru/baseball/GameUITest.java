package com.neurumaru.baseball;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameUITest {
    @Test
    void getStringTest() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("Test.TestTag", "Test String");
        GameUI gameUI = new GameUI(System.in, System.out, stringMap);
        assertThat(gameUI.getString("Test.TestTag")).isEqualTo("Test String");
        assertThat(gameUI.getString("Test.NoExist")).isEqualTo(null);
    }

    @Test
    void mapStringTest() {
        Map<String, String> map = new HashMap<>();
        map.put("{0}", "10");
        GameUI gameUI = new GameUI(System.in, System.out);
        assertThat(gameUI.mapString("5 + 5 = {0}", map)).isEqualTo("5 + 5 = 10");
        assertThat(gameUI.mapString("{0} + {0} = 20", map)).isEqualTo("10 + 10 = 20");
        assertThat(gameUI.mapString("5 + 5 = {1}", map)).isEqualTo("5 + 5 = {1}");
    }
}
