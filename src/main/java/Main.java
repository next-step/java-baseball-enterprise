public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        boolean willContinue = true;
        while (willContinue) {
            game.reset();
            game.start();
            willContinue = game.willContinue();
        }
    }
}
