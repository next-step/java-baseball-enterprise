package game;


import console.Console;
import console.Menu;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private final Console console;
    private int[] answer;

    public Game() {
        this.console = new Console();
        answer = new int[3];
    }

    public void start(){
        makeRandomNumber();
        int[] playerAnswer = console.getPlayerAnswer();

    }

    private void makeRandomNumber() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int idx = 0; idx < 3; idx++) {
            answer[idx] = numbers.get(idx);
        }
    }

    public boolean checkGameAgain(){
        return Menu.isDoGame(console.getGameMenu());
    }
}
