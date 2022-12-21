package num3baseball.manager;

import num3baseball.dataobject.NumBalls;
import num3baseball.dataobject.NumBallsNBalls;
import num3baseball.dataobject.TrialResult;
import num3baseball.exception.WrongNumberException;
import num3baseball.ui.GameUserInterface;

import java.sql.Array;
import java.util.ArrayList;

public class GameManager {
    private GameUserInterface gameUserInterface;
    private final NumBalls answer;

    private final int size;

    public GameManager(GameUserInterface gameUserInterface, NumBalls numBalls, int size){
        this.gameUserInterface = gameUserInterface;
        answer = numBalls;
        this.size=size;
    }

    public boolean executeOneCycle(){
        try{
            TrialResult result = answer.compare(new NumBallsNBalls(gameUserInterface.inputNumbers()));
            gameUserInterface.printResult(result);
            return result.getStrike() == result.getSize();
        }
        catch(Exception e){
            gameUserInterface.printError(e);
        }
        return false;
    }
    public void execute(){
        while(!executeOneCycle()) {
        }
        gameUserInterface.printGameClear(size);
    }
}
