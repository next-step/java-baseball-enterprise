package Service;

import Repository.GameRepository;

import java.util.ArrayList;
import java.util.Scanner;

import static util.Message.START_GAME;
import static util.Message.USER_INPUT;

public class GameService {

    public GameRepository gameRepository;
    public ErrorService errorService;

    public GameService() {
        this.gameRepository = new GameRepository();
        this.errorService = new ErrorService(this.gameRepository); // DI
    }

    public void playGame(){
        printStartGameMessage();    // 게임 시작 메시지 출력
        printInputMessage();        // 입력 메시지 출력
        getInputNumbers();          // 유저 입력
        checkUserInputNumbers();    // 유저 입력 검증
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

    public boolean checkUserInputNumbers(){
        return errorService.checkUserInputNumber();
    }
}

