package Service;

import Repository.GameRepository;

import java.util.ArrayList;

import static util.Message.START_GAME;

public class GameService {

    public GameRepository gameRepository;

    public GameService() {
        this.gameRepository = new GameRepository();
    }

    public void printStartGameMessage(){
        System.out.println(START_GAME.getMessage());
    }

    public ArrayList<Integer> getNumbers(){
        return gameRepository.getNumbers();
    }
}

