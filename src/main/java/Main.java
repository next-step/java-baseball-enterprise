import game.Game;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
        do {
            game.start();
        } while (game.checkGameAgain());
    }
}
