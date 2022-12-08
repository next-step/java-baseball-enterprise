package Controller;

import Service.GameService;

public class GameController {

    private GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    /**
     * 1) 게임 시작 문구 출력
     */
    public void startGame(){
        gameService.printStartGameMessage();
    }


}
