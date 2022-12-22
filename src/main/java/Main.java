import game.Game;
import game.GameInterface;

public class Main {
    public static void main(String[] args) {
        var ui = new GameInterface();
        ui.printHints();
        procloop: while (true) {
            var game = Game.randomGame();
            gameloop: while (true) {
                var userNumber = ui.scanUserNumber();
                var result = game.calculateGameResults(userNumber);
                ui.printGameResult(result);
                if(result.isAllStrike()){
                    break gameloop;
                }
            }
            var menu = ui.scanRetryMenu();
            if(menu == 2){
                break procloop;
            }
        }
    }
}
