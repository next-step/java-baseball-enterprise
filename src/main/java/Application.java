import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        boolean start = true;

        while(start){
            Game game = new Game();
            game.start();
            start = game.replay();
        }
    }
}
