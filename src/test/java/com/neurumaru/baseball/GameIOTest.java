package com.neurumaru.baseball;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameIOTest {
    @Test
    void getStringTest() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("Test.TestTag", "Test String");
        GameIO gameIO = new GameIO(System.in, System.out, stringMap);
        assertThat(gameIO.getString("Test.TestTag")).isEqualTo("Test String");
        assertThat(gameIO.getString("Test.NoExist")).isEqualTo(null);
    }

    @Test
    void mapStringTest() {
        Map<String, String> map = new HashMap<>();
        map.put("{0}", "10");
        GameIO gameIO = new GameIO(System.in, System.out);
        assertThat(gameIO.mapString("5 + 5 = {0}", map)).isEqualTo("5 + 5 = 10");
        assertThat(gameIO.mapString("{0} + {0} = 20", map)).isEqualTo("10 + 10 = 20");
        assertThat(gameIO.mapString("5 + 5 = {1}", map)).isEqualTo("5 + 5 = {1}");
    }

    @Test
    void getMappedStringTest() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("Test.TestTag", "{0} * {0} = {1}");
        Map<String, String> map = new HashMap<>();
        map.put("{0}", "10");
        map.put("{1}", "100");
        GameIO gameIO = new GameIO(System.in, System.out, stringMap);
        assertThat(gameIO.getMappedString("Test.TestTag", map)).isEqualTo("10 * 10 = 100");
    }
}
