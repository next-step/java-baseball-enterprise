package Service;

import Repository.GameRepository;

import java.util.ArrayList;
import java.util.Scanner;

import static util.Message.START_GAME;
import static util.Message.USER_INPUT;

public class GameService {

    public GameRepository gameRepository;

    public GameService() {
        this.gameRepository = new GameRepository();
    }

    public void playGame(){
        printStartGameMessage();    // 게임 시작 메시지 출력
        printInputMessage();        // 입력 메시지 출력
        getInputNumbers();          // 유저 입력
    }

    public void printStartGameMessage(){
        System.out.println(START_GAME.getMessage());
    }

    public ArrayList<Integer> getNumbers(){
        return gameRepository.getNumbers();
    }

    public void printInputMessage(){
        System.out.print(USER_INPUT.getMessage());
    }

    public void getInputNumbers(){
        Scanner input = new Scanner(System.in);
        String userNumbers = input.nextLine();
        gameRepository.setUserNumber(userNumbers); // 데이터는 Repository 단에서 관리해야 한다.
    }

}

