package game;

import exception.GameCommandNoutFoundException;

import java.util.HashMap;
import java.util.Map;

public enum GameCommand {

    RESTART(1),
    END(2);

    private static final Map<Integer, GameCommand> gameCommandMapping = new HashMap<>();

    static {
        for (GameCommand gameCommand : GameCommand.values()) {
            gameCommandMapping.put(
                    gameCommand.getCommandNumber(),
                    gameCommand
            );
        }
    }

    private final int commandNumber;

    GameCommand(int commandNumber) {
        this.commandNumber = commandNumber;
    }

    public static GameCommand getCommand(int commandNumber) {
        if (!gameCommandMapping.containsKey(commandNumber)) {
            throw new GameCommandNoutFoundException();
        }

        return gameCommandMapping.get(commandNumber);
    }

    public int getCommandNumber() {
        return commandNumber;
    }
}
