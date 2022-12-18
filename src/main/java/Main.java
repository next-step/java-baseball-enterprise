public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        while (true) {
            game.reset();
            game.start();
            if (!game.willContinue())
                break;
        }
    }
}
