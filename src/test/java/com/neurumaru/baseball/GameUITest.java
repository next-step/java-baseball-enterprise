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
}
