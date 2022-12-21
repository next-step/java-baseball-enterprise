package num3baseball.ui;

import num3baseball.dataobject.TrialResult;
import num3baseball.exception.WrongNumberException;

import java.util.ArrayList;

public class GameUserInterfaceTestStub implements GameUserInterface{

    private ArrayList<Integer> input;
    @Override
    public ArrayList<Integer> inputNumbers() {
        return input;
    }

    public GameUserInterface inputNumbers(ArrayList<Integer> input){
        this.input = input;
        return this;
    }

    public TrialResult res;
    @Override
    public void printResult(TrialResult res) {
        this.res = res;
    }

    @Override
    public void printError(Exception e){
        if (e instanceof WrongNumberException) {
            throw (WrongNumberException)e;
        }
        if (e instanceof NumberFormatException) {
            throw (NumberFormatException)e;
        }
    }

    @Override
    public void printGameClear(int size) {

    }

    private boolean retry;
    @Override
    public boolean printRetry() {
        return retry;
    }

    public GameUserInterface printRetry(boolean retry){
        this.retry=retry;
        return this;
    }
}

