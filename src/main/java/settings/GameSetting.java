package settings;

import ui.InputManager;
import ui.OutputManager;

public class GameSetting {

    private final InputManager inputManager;

    private final OutputManager outputManager;

    private GameSetting() {
        inputManager = new InputManager(System.in);
        outputManager = new OutputManager(System.out);
    }

    public static GameSetting getInstance() {
        return GameSettingHolder.GAME_SETTING;
    }

    public InputManager getInputManager() {
        return inputManager;
    }

    public OutputManager getOutputManager() {
        return outputManager;
    }

    private static class GameSettingHolder {
        private static final GameSetting GAME_SETTING = new GameSetting();
    }
}
