package game;


import console.InputConsole;
import console.Menu;

public class Game {

    private final InputConsole inputConsole;
    private String answerNumber;

    public Game() {
        this.inputConsole = new InputConsole();
    }

    public boolean checkGameAgain(){
        return Menu.isDoGame(inputConsole.getGameMenu());
    }
}
