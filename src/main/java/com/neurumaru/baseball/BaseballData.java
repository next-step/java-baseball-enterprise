package com.neurumaru.baseball;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseballData {
    public static final String LANGUAGE_DATA_TAG = "LanguageData";
    public static final String REQUEST_INPUT_NUMBER_TAG = "Baseball.RequestInputNumber";
    public static final String STRIKE_TAG = "Baseball.Strike";
    public static final String BALL_TAG = "Baseball.Ball";
    public static final String NOTHING_TAG = "Baseball.Nothing";
    public static final String GAME_TERMINATION_TAG = "Baseball.GameTermination";
    public static final String RESTART_TAG = "Baseball.Restart";
    public static final String REQUEST_INPUT_NUMBER_DEFAULT = "Input Number : ";
    public static final String STRIKE_DEFAULT = "{0} Strike ";
    public static final String BALL_DEFAULT = "{0} Ball ";
    public static final String NOTHING_DEFAULT = "Nothing";
    public static final String GAME_TERMINATION_DEFAULT = "You got all {0} numbers right! Terminate Game";
    public static final String RESTART_DEFAULT = "Enter {0} to start a new game or {1} to quit";

    public static Map<String, String> getDefaultLanguageDataMap() {
        Map<String, String> languageData = new HashMap<>();
        languageData.put(REQUEST_INPUT_NUMBER_TAG, REQUEST_INPUT_NUMBER_DEFAULT);
        languageData.put(STRIKE_TAG, STRIKE_DEFAULT);
        languageData.put(BALL_TAG, BALL_DEFAULT);
        languageData.put(NOTHING_TAG, NOTHING_DEFAULT);
        languageData.put(GAME_TERMINATION_TAG, GAME_TERMINATION_DEFAULT);
        languageData.put(RESTART_TAG, RESTART_DEFAULT);
        return languageData;
    }

    public static Map<String, String> getLanguageDataMap(String filename) {
        try {
            return XmlParser.getHashMap(filename, LANGUAGE_DATA_TAG);
        } catch (IOException e) {
            return getDefaultLanguageDataMap();
        }
    }

    public static Map<String, String> getStrikeMap(int strike) {
        Map<String, String> map = new HashMap<>();
        map.put("{0}", String.valueOf(strike));
        return map;
    }

    public static Map<String, String> getBallMap(int ball) {
        Map<String, String> map = new HashMap<>();
        map.put("{0}", String.valueOf(ball));
        return map;
    }

    public static Map<String, String> getGameTerminationMap(int digit) {
        Map<String, String> map = new HashMap<>();
        map.put("{0}", String.valueOf(digit));
        return map;
    }

    public static Map<String, String> getRestartMap(int restart, int quit) {
        Map<String, String> map = new HashMap<>();
        map.put("{0}", String.valueOf(restart));
        map.put("{1}", String.valueOf(quit));
        return map;
    }
}
