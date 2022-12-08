package Controller;

import Service.GameService;

public class GameController {

    private GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void startGame(){
        gameService.playGame();
    }


}
