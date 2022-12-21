package game;


import console.InputConsole;
import console.Menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Game {

    private final InputConsole inputConsole;
    private int[] answerNumber;

    public Game() {
        this.inputConsole = new InputConsole();
    }

    public void start(){
        makeRandomNumber();
    }

    private void makeRandomNumber() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int idx = 0; idx < 3; idx++) {
            answerNumber[idx] = numbers.get(idx);
        }
    }

    public boolean checkGameAgain(){
        return Menu.isDoGame(inputConsole.getGameMenu());
    }
}
