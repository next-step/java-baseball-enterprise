package num3baseball.manager;

import num3baseball.dataobject.NumBallsNBalls;
import num3baseball.ui.GameUserInterface;

public class ProcessManager {
    private GameUserInterface gameUserInterface;
    private GameManager gameManager;

    public ProcessManager(GameUserInterface gameUserInterface){
        this.gameUserInterface = gameUserInterface;
    }

    public void setGameUserInterface(GameUserInterface gameUserInterface) {
        this.gameUserInterface = gameUserInterface;
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void execute(){
        do{
            setGameManager(new GameManager(gameUserInterface, new NumBallsNBalls(3), 3));
            gameManager.execute();
        }while(gameUserInterface.printRetry());
    }
}
