package Controller;

import util.Message;

import static util.Message.START_GAME;

public class GameController {

    /**
     * 1) 게임 시작 문구 출력
     */
    public void startGame(){
        System.out.println(START_GAME.getMessage());
    }
}
