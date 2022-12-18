package com.neurumaru.baseball;

import java.util.Map;

public class Baseball {
    public static void main(String[] args) {
        Map<String, String> languageDataMap = BaseballData.getLanguageDataMap(BaseballConfig.KOREAN_FILENAME);
        GameIO gameIO = new GameIO(System.in, System.out, languageDataMap);
        BaseballGame baseballGame = new BaseballGame(gameIO, BaseballConfig.DIGIT_DEFAULT,
                BaseballConfig.RESTART_NUMBER, BaseballConfig.QUIT_NUMBER);
        baseballGame.repeatGame();
    }
}
