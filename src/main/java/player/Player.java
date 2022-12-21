package player;

import game.BaseBallGame;
import game.GameCommand;
import opponent.Opponent;
import settings.GameSetting;
import ui.InputManager;

public class Player {

    public void start() {
        InputManager inputManager = GameSetting.getInstance().getInputManager();
        do {
            playRound();
        } while (inputManager.getInputGameCommand() == GameCommand.RESTART);
    }

    protected void playRound() {
        Opponent opponent = new Opponent();
        BaseBallGame baseBallGame = new BaseBallGame(opponent);
        baseBallGame.start();
    }


}
