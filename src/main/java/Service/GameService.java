package Service;

import Repository.GameRepository;

import static util.Message.START_GAME;

public class GameService {

    public GameRepository gameRepository;

    public GameService() {
        this.gameRepository = new GameRepository();
    }

    public void printStartGameMessage(){
        System.out.println(START_GAME.getMessage());
    }
}

