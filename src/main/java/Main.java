import game.Game;
import game.GameInterface;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var ui = new GameInterface();
        ui.printHints();
        procloop: while (true) {
            var game = Game.expectedGame(1, 9, 5);
            System.out.println(Arrays.toString(game.actualValues));
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
